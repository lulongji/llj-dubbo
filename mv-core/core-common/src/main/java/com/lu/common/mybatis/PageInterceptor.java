package com.lu.common.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

/**
 * 通过拦截<code>StatementHandler</code>的<code>prepare</code>方法，重写sql语句实现物理分页。
 * 签名里要拦截的类型只能是接口。
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
	private static final Log logger = LogFactory.getLog(PageInterceptor.class);
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static String oracletDialect = "Oracle"; // 数据库类型(默认为mysql)
	private static String mysqlDialect = "MySQL"; // 数据库类型(默认为mysql)
	private static String defaultPageSqlId = ".*Page$"; // 需要拦截的ID(正则匹配)
	private String pageSqlId = defaultPageSqlId; // 需要拦截的ID(正则匹配)
	private String dialect;

	public void setPageSqlId(String pageSqlId) {
		this.pageSqlId = pageSqlId;
	}

	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation
				.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(
				statementHandler, DEFAULT_OBJECT_FACTORY,
				DEFAULT_OBJECT_WRAPPER_FACTORY);
		// 分离代理对象链(由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环可以分离出最原始的的目标类)
		while (metaStatementHandler.hasGetter("h")) {
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = MetaObject.forObject(object,
					DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		}
		// 分离最后一个代理对象的目标类
		while (metaStatementHandler.hasGetter("target")) {
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = MetaObject.forObject(object,
					DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		}
		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");  
//		dialect = metaStatementHandler.getValue(
//				"delegate.configuration.databaseId").toString();
		dialect = configuration.getVariables().getProperty("dialect");  
	     if (null == dialect || "".equals(dialect)) {  
	         dialect = mysqlDialect;  
	     }  
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
				.getValue("delegate.mappedStatement");
		// 只重写需要分页的sql语句。通过MappedStatement的ID匹配，默认重写以Page结尾的MappedStatement的sql
		if (mappedStatement.getId().matches(pageSqlId)) {
			BoundSql boundSql = (BoundSql) metaStatementHandler
					.getValue("delegate.boundSql");
			Object parameterObject = boundSql.getParameterObject();
			if (parameterObject == null) {
				throw new NullPointerException("parameterObject is null!");
			} else {
				ParameterHandler parameterHandler = (ParameterHandler) metaStatementHandler
						.getValue("delegate.parameterHandler");
				Page<?> page = (Page<?>) metaStatementHandler
						.getValue("delegate.boundSql.parameterObject.page");
				String sql = boundSql.getSql();
				Connection connection = (Connection) invocation.getArgs()[0];

				// 重设分页参数里的总页数等
				setPageParameter(sql, connection, parameterHandler, page);

				// 重写sql
				String pageSql = buildPageSql(sql, page);
				metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
				// 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
				metaStatementHandler.setValue("delegate.rowBounds.offset",
						RowBounds.NO_ROW_OFFSET);
				metaStatementHandler.setValue("delegate.rowBounds.limit",
						RowBounds.NO_ROW_LIMIT);
			}
		}
		// 将执行权交给下一个拦截器
		return invocation.proceed();
	}

	private void setPageParameter(String sql, Connection connection,
			ParameterHandler parameterHandler, Page<?> page) {
		// 记录总记录数
		String countSql = "select count(0) from (" + sql + ") t";
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		
		try {

			countStmt = connection.prepareStatement(countSql);
			parameterHandler.setParameters(countStmt);

			rs = countStmt.executeQuery();
			
			int totalCount = 0;
			if (rs != null) {
				if (rs.next()) {
					totalCount = rs.getInt(1);
				}
			}else{
				logger.error("error sql "+countSql);
			}

			page.setTotalRecord(totalCount);
		} catch (SQLException e) {
			logger.error("Ignore this exception", e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
			try {
				if(countStmt != null){
					countStmt.close();
				}
			} catch (SQLException e) {
				logger.error("Ignore this exception", e);
			}
		}
	}

	/**
	 * 根据数据库类型，生成特定的分页sql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	private String buildPageSql(String sql, Page<?> page) {
		if (page != null) {
			StringBuilder pageSql = new StringBuilder();
			if (mysqlDialect.equals(dialect)) {
				pageSql = buildPageSqlForMysql(sql, page);
			} else if (oracletDialect.equals(dialect)) {
				pageSql = buildPageSqlForOracle(sql, page);
			} else {
				return sql;
			}
			
			return pageSql.toString();
		} else {
			return sql;
		}
	}

	/**
	 * mysql的分页语句
	 * 
	 * @param sql
	 * @param page
	 * @return String
	 */
	private StringBuilder buildPageSqlForMysql(String sql, Page<?> page) {
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf(page.getBeginRow());
		pageSql.append(sql);
		pageSql.append(" limit " + beginrow + "," + page.getPageSize());

		return pageSql;
	}

	/**
	 * 成oracle的分页
	 * 
	 * @param sql
	 * @param page
	 * @return String
	 */
	private StringBuilder buildPageSqlForOracle(String sql, Page<?> page) {
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf(page.getBeginRow());
		String endrow = String.valueOf(page.getEndRow());

		pageSql.append("select * from ( select t.*, rownum row_id from ( ");
		pageSql.append(sql);
		pageSql.append(" ) t where rownum <= ").append(endrow);
		pageSql.append(") where row_id > ").append(beginrow);

		return pageSql;
	}

	public Object plugin(Object target) {
		// 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的次数
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	public void setProperties(Properties properties) {
		pageSqlId = properties.getProperty("pageSqlId");
	}

}
