package com.lu.common.mybatis.dao;

import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import com.lu.common.mybatis.IBaseMapper;
import com.lu.common.mybatis.Page;
import com.lu.common.mybatis.annotation.Column;
import com.lu.common.mybatis.annotation.Id;
import com.lu.common.mybatis.annotation.Table;

public class BaseDaoImpl implements IBaseDao, InitializingBean {
	private static final Log logger = LogFactory.getLog(BaseDaoImpl.class);

	private SqlSessionTemplate sessionTemplate;

	private SqlSessionFactory sessionFactory;

	public static final String SQL_NAME = "sql";
	private static final String GET = "get";
	private static final String SET = "set";

	private static Map<String, Bean> beanMapping = new HashMap<String, Bean>();

	private Resource[] beans;

	@Override
	public int insert(Class<? extends IBaseMapper> mapper, Object obj) throws Exception {
		return getSessionTemplate().getMapper(mapper).insert(obj);
	}

	@Override
	public int insertBySql(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception {
		return getSessionTemplate().getMapper(mapper).insertBySql(map);
	}

	@Override
	public int delete(Class<? extends IBaseMapper> mapper, Class<?> clazz, Serializable id) throws Exception {
		Bean bean = beanMapping.get(clazz.getName());
		SQL sql = new SQL();
		sql.DELETE_FROM(bean.getTable());
		sql.WHERE(bean.getIdCol() + "=#{" + bean.getId() + "}");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(bean.getId(), id);
		map.put(SQL_NAME, sql.toString());
		return deleteBySql(mapper, map);
	}

	@Override
	public int deleteBySql(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception {
		return getSessionTemplate().getMapper(mapper).delete(map);
	}

	@Override
	public int update(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj) throws Exception {
		Bean bean = beanMapping.get(clazz.getName());
		try {
			SQL sql = new SQL();
			Map<String, Object> map = new HashMap<String, Object>();
			Method idMethod = obj.getClass().getMethod(bean.getIdGetMethod());
			idMethod.setAccessible(true);
			Object id = idMethod.invoke(obj);
			if (id == null) {
				throw new Exception("id值为null");
			}

			sql.UPDATE(bean.getTable());
			Set<Entry<String, String>> sets = bean.getFieldGetMethods().entrySet();
			Iterator<Entry<String, String>> it = sets.iterator();
			while (it.hasNext()) {
				Entry<String, String> en = it.next();
				Method m = obj.getClass().getMethod(en.getValue());
				m.setAccessible(false);
				Object value = m.invoke(obj);
				if (value != null) {
					sql.SET(bean.getFieldCols().get(en.getKey()) + "=#{" + en.getKey() + "}");
					map.put(en.getKey(), value);
				}
			}

			if (map.size() < 1) {
				return 0;
			}
			sql.WHERE(bean.getIdCol() + "=#{" + bean.getId() + "}");
			map.put(bean.getId(), id);
			map.put(SQL_NAME, sql.toString());
			return updateBySql(mapper, map);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public int updateBySql(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception {
		return getSessionTemplate().getMapper(mapper).update(map);
	}

	@Override
	public Object get(Class<? extends IBaseMapper> mapper, Class<?> clazz, Serializable id) throws Exception {
		if (id == null) {
			return null;
		}
		SQL sql = new SQL();
		Bean beanInfo = beanMapping.get(clazz.getName());
		Map<String, Object> map = new HashMap<String, Object>();

		sql.SELECT("*");
		sql.FROM(beanInfo.getTable());
		sql.WHERE(beanInfo.getIdCol() + "=#{" + beanInfo.getId() + "}");
		map.put(beanInfo.getId(), id);
		map.put(SQL_NAME, sql.toString());
		List<Object> list = getList(mapper, map);
		return list != null && list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public Object getOne(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj) throws Exception {
		List<Object> list = getListByOne(mapper, clazz, obj);
		if (list != null) {
			if (list.size() > 1) {
				throw new Exception("Expect to get a value, but for the multiple");
			} else if (list.size() == 0) {
				return null;
			} else {
				return list.get(0);
			}
		}
		return null;
	}

	@Override
	public List<Object> getList(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception {
		return getSessionTemplate().getMapper(mapper).select(map);
	}

	@Override
	public List<Object> getListByOne(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj) throws Exception {
		Bean bean = beanMapping.get(clazz.getName());
		Map<String, Object> params = new HashMap<String, Object>();
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(bean.getTable());
		buildWhere(sql, bean, obj, params);
		params.put(SQL_NAME, sql.toString());
		return getList(mapper, params);
	}

	@Override
	public List<Object> getListByOne(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj, Map<String, Boolean> orderBy) throws Exception {
		Bean bean = beanMapping.get(clazz.getName());
		Map<String, Object> params = new HashMap<String, Object>();
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(bean.getTable());
		buildWhere(sql, bean, obj, params);

		if (orderBy != null && !orderBy.isEmpty()) {
			for (Entry<String, Boolean> entry : orderBy.entrySet()) {
				if (entry.getValue()) {
					if (entry.getKey().indexOf("_") == -1) {
						if (entry.getKey().equals(bean.getId())) {
							sql.ORDER_BY(bean.getIdCol() + " asc");
						} else {
							sql.ORDER_BY(bean.getFieldCols().get(entry.getKey()) + " asc");
						}
					} else {
						sql.ORDER_BY(entry.getKey() + " asc");
					}

				} else {
					if (entry.getKey().indexOf("_") == -1) {
						if (entry.getKey().equals(bean.getId())) {
							sql.ORDER_BY(bean.getIdCol() + " desc");
						} else {
							sql.ORDER_BY(bean.getFieldCols().get(entry.getKey()) + " desc");
						}
					} else {
						sql.ORDER_BY(entry.getKey() + " desc");
					}
				}
			}
		}

		params.put(SQL_NAME, sql.toString());

		return getList(mapper, params);
	}

	@Override
	public Long getCountBySql(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception {
		return getSessionTemplate().getMapper(mapper).selectCount(map);
	}

	@Override
	public Long getTotalSize(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj) throws Exception {
		Bean bean = beanMapping.get(clazz.getName());
		Map<String, Object> params = new HashMap<String, Object>();
		SQL sql = new SQL();
		sql.SELECT("count(*)");
		sql.FROM(bean.getTable());
		buildWhere(sql, bean, obj, params);
		params.put(SQL_NAME, sql.toString());
		return getCountBySql(mapper, params);
	}

	@Override
	public Long getTotalSize(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj, Map<String, Boolean> orderBy) throws Exception {
		Bean bean = beanMapping.get(clazz.getName());
		Map<String, Object> params = new HashMap<String, Object>();
		SQL sql = new SQL();
		sql.SELECT("count(*)");
		sql.FROM(bean.getTable());
		buildWhere(sql, bean, obj, params);

		params.put(SQL_NAME, sql.toString());

		return getCountBySql(mapper, params);
	}

	public Long getTotalSize(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj, String tableName) throws Exception {
		Bean bean = beanMapping.get(clazz.getName());
		Map<String, Object> params = new HashMap<String, Object>();
		SQL sql = new SQL();
		sql.SELECT("count(*)");
		if (StringUtils.isNotBlank(tableName)) {
			sql.FROM(" " + tableName + " ");
		} else {
			sql.FROM(bean.getTable());
		}
		buildWhere(sql, bean, obj, params);
		params.put(SQL_NAME, sql.toString());
		return getCountBySql(mapper, params);
	}

	@Override
	public List<Object> getList(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj, int p, int size) throws Exception {
		Bean bean = beanMapping.get(clazz.getName());
		Map<String, Object> params = new HashMap<String, Object>();
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(bean.getTable());

		String _sql = "";
		if (obj != null) {
			buildWhere(sql, bean, obj, params);

			_sql = sql.toString();
			if (p >= 1 && size >= 1) {
				_sql += " limit #{start},#{size} ";
				params.put("start", (p - 1) * size);
				params.put("size", size);
			}
		}

		params.put(SQL_NAME, _sql);

		return getList(mapper, params);
	}

	@Override
	public Page<Object> getPageList(Class<? extends IBaseMapper> mapper, Class<?> clazz, Page<Object> page, Map<String, Boolean> orderBy)
			throws Exception {
		page.setTotalRecord(getTotalSize(mapper, clazz, page.getModel()).intValue());
		Bean bean = beanMapping.get(clazz.getName());
		Map<String, Object> params = new HashMap<String, Object>();
		SQL sql = new SQL();
		sql.SELECT("*");
		sql.FROM(bean.getTable());

		String _sql = "";
		if (page != null) {
			buildWhere(sql, bean, page.getModel(), params);

			if (orderBy != null && !orderBy.isEmpty()) {
				for (Entry<String, Boolean> entry : orderBy.entrySet()) {
					if (entry.getValue()) {
						if (entry.getKey().indexOf("_") == -1) {
							if (entry.getKey().equals(bean.getId())) {
								sql.ORDER_BY(bean.getIdCol() + " asc");
							} else {
								sql.ORDER_BY(bean.getFieldCols().get(entry.getKey()) + " asc");
							}
						} else {
							sql.ORDER_BY(entry.getKey() + " asc");
						}

					} else {
						if (entry.getKey().indexOf("_") == -1) {
							if (entry.getKey().equals(bean.getId())) {
								sql.ORDER_BY(bean.getIdCol() + " desc");
							} else {
								sql.ORDER_BY(bean.getFieldCols().get(entry.getKey()) + " desc");
							}
						} else {
							sql.ORDER_BY(entry.getKey() + " desc");
						}
					}
				}
			}

			_sql = sql.toString();
			if (page.getCurrentPageNo() >= 1 && page.getPageSize() >= 1) {
				_sql += " limit #{start},#{size} ";
				params.put("start", page.getBeginRow());
				params.put("size", page.getPageSize());
			}
		}

		params.put(SQL_NAME, _sql);

		page.setResult(getList(mapper, params));

		return page;
	}

	public Page<Object> getPageList(Class<? extends IBaseMapper> mapper, Class<?> clazz, Page<Object> page, Map<String, Boolean> orderBy,
			String tableName) throws Exception {
		Bean bean = beanMapping.get(clazz.getName());
		Map<String, Object> params = new HashMap<String, Object>();
		SQL sql = new SQL();
		sql.SELECT("*");
		if (StringUtils.isNotBlank(tableName)) {
			page.setTotalRecord(getTotalSize(mapper, clazz, page.getModel(), tableName).intValue());
			sql.FROM(" " + tableName + " ");
		} else {
			sql.FROM(bean.getTable());
			page.setTotalRecord(getTotalSize(mapper, clazz, page.getModel()).intValue());
		}

		String _sql = "";
		if (page != null) {
			buildWhere(sql, bean, page.getModel(), params);

			if (orderBy != null && !orderBy.isEmpty()) {
				for (Entry<String, Boolean> entry : orderBy.entrySet()) {
					if (entry.getValue()) {
						if (entry.getKey().indexOf("_") == -1) {
							if (entry.getKey().equals(bean.getId())) {
								sql.ORDER_BY(bean.getIdCol() + " asc");
							} else {
								sql.ORDER_BY(bean.getFieldCols().get(entry.getKey()) + " asc");
							}
						} else {
							sql.ORDER_BY(entry.getKey() + " asc");
						}

					} else {
						if (entry.getKey().indexOf("_") == -1) {
							if (entry.getKey().equals(bean.getId())) {
								sql.ORDER_BY(bean.getIdCol() + " desc");
							} else {
								sql.ORDER_BY(bean.getFieldCols().get(entry.getKey()) + " desc");
							}
						} else {
							sql.ORDER_BY(entry.getKey() + " desc");
						}
					}
				}
			}

			_sql = sql.toString();
			if (page.getCurrentPageNo() >= 1 && page.getPageSize() >= 1) {
				_sql += " limit #{start},#{size} ";
				params.put("start", page.getBeginRow());
				params.put("size", page.getPageSize());
			}
		}

		params.put(SQL_NAME, _sql);

		page.setResult(getList(mapper, params));

		return page;
	}

	@Override
	public Map<String, Object> getMapResult(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception {
		return getSessionTemplate().getMapper(mapper).selectMap(map);
	}

	/**
	 * 创建 条件 查询语句
	 * 
	 * @param sql
	 * @param bean
	 * @param obj
	 * @param map
	 */
	private void buildWhere(SQL sql, Bean bean, Object obj, Map<String, Object> map) {
		if (obj != null) {
			Map<String, String> fields = bean.getFieldGetMethods();
			Set<Entry<String, String>> sets = fields.entrySet();
			Iterator<Entry<String, String>> it = sets.iterator();
			while (it.hasNext()) {
				Entry<String, String> en = it.next();
				try {
					Method m = obj.getClass().getMethod(en.getValue());
					m.setAccessible(false);
					Object value = m.invoke(obj);
					if (value != null) {
						sql.WHERE(bean.getFieldCols().get(en.getKey()) + "=#{" + en.getKey() + "}");
						map.put(en.getKey(), value);
					}
				} catch (Exception e) {
					new Exception(e);
				}
			}
		}
	}

	@Override
	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Resource[] getBeans() {
		return beans;
	}

	public void setBeans(Resource[] beans) {
		this.beans = beans;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (beans == null || beans.length == 0) {
			throw new Exception("the beans must be not null");
		}

		logger.debug("It's start to init ...");
		init();
		logger.debug("init complete ...");

		if (sessionTemplate == null && sessionFactory != null) {
			this.sessionTemplate = new SqlSessionTemplate(sessionFactory);
		}
		if (sessionTemplate == null && sessionFactory == null) {
			throw new Exception("sessionTemplate or sessionFactory is not null");
		}
	}

	/**
	 * 初始化
	 */
	private void init() {
		try {
			ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
			MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
			for (Resource bean : beans) {
				if (bean.isReadable()) {
					MetadataReader reader = metadataReaderFactory.getMetadataReader(bean);
					String className = reader.getAnnotationMetadata().getClassName();
					try {
						Class<? extends Object> clazz = Class.forName(className);
						convertBean(clazz);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (LinkageError e) {
						e.printStackTrace();
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 转换
	 * 
	 * @param clazz
	 */
	private void convertBean(Class<? extends Object> clazz) {
		logger.debug("It's start to init bean[" + clazz.getName() + "]");
		Bean bean = new Bean();
		String table = clazz.getAnnotation(Table.class) == null ? "" : clazz.getAnnotation(Table.class).value();
		bean.setTable(table == null || "".equalsIgnoreCase(table) ? clazz.getSimpleName() : table);

		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(false);
			for (Annotation annotation : field.getAnnotations()) {
				String fieldName = field.getName();
				if (annotation instanceof Column) {
					bean.getFieldCols().put(fieldName, ((Column) annotation).value());
					bean.getFieldGetMethods().put(fieldName, GET + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
					bean.getFieldSetMethods().put(fieldName, SET + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
					bean.getFieldTypes().put(fieldName, field.getType().getName());
				} else if (annotation instanceof Id) {
					bean.setId(fieldName);
					bean.setIdCol(((Id) annotation).value());
					bean.setIdType(field.getType().getName());
					bean.setIdGetMethod(GET + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
					bean.setIdSetMethod(SET + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
				}
			}

			beanMapping.put(clazz.getName(), bean);
		}

	}

	/**
	 * 基类
	 * 
	 * @author yang
	 *
	 */
	static class Bean {
		private String table;

		private String id;
		private String idCol;
		private String idType;
		private String idGetMethod;
		private String idSetMethod;

		private Map<String, String> fieldGetMethods = new HashMap<String, String>();
		private Map<String, String> fieldSetMethods = new HashMap<String, String>();
		private Map<String, String> fieldCols = new HashMap<String, String>();
		private Map<String, String> fieldTypes = new HashMap<String, String>();

		public String getTable() {
			return table;
		}

		public void setTable(String table) {
			this.table = table;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getIdCol() {
			return idCol;
		}

		public void setIdCol(String idCol) {
			this.idCol = idCol;
		}

		public String getIdType() {
			return idType;
		}

		public void setIdType(String idType) {
			this.idType = idType;
		}

		public String getIdGetMethod() {
			return idGetMethod;
		}

		public void setIdGetMethod(String idGetMethod) {
			this.idGetMethod = idGetMethod;
		}

		public String getIdSetMethod() {
			return idSetMethod;
		}

		public void setIdSetMethod(String idSetMethod) {
			this.idSetMethod = idSetMethod;
		}

		public Map<String, String> getFieldGetMethods() {
			return fieldGetMethods;
		}

		public void setFieldGetMethods(Map<String, String> fieldGetMethods) {
			this.fieldGetMethods = fieldGetMethods;
		}

		public Map<String, String> getFieldSetMethods() {
			return fieldSetMethods;
		}

		public void setFieldSetMethods(Map<String, String> fieldSetMethods) {
			this.fieldSetMethods = fieldSetMethods;
		}

		public Map<String, String> getFieldCols() {
			return fieldCols;
		}

		public void setFieldCols(Map<String, String> fieldCols) {
			this.fieldCols = fieldCols;
		}

		public Map<String, String> getFieldTypes() {
			return fieldTypes;
		}

		public void setFieldTypes(Map<String, String> fieldTypes) {
			this.fieldTypes = fieldTypes;
		}

	}

}
