package com.lu.common.mybatis.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.lu.common.mybatis.IBaseMapper;
import com.lu.common.mybatis.Page;
import com.lu.common.mybatis.dao.BaseDaoImpl;
import com.lu.common.mybatis.dao.IBaseDao;

public class BaseServiceImpl<T, M extends IBaseMapper> implements IBaseService<T> {
	@Autowired
	protected IBaseDao baseDao;

	protected Class<T> clazz;

	protected Class<M> mapper;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] ps = ((ParameterizedType) type).getActualTypeArguments();
			clazz = (Class<T>) ps[0];
			mapper = (Class<M>) ps[1];
		}
	}

	@Override
	public int insert(T t) throws Exception {
		return this.baseDao.insert(mapper, t);
	}

	@Override
	public int insertBySql(String sql, Map<String, Object> params) throws Exception {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		params.put(BaseDaoImpl.SQL_NAME, sql);
		return this.baseDao.insertBySql(mapper, params);
	}

	@Override
	public int delete(Serializable id) throws Exception {
		return this.baseDao.delete(mapper, clazz, id);
	}

	@Override
	public int deleteBySql(String sql, Map<String, Object> params) throws Exception {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		params.put(BaseDaoImpl.SQL_NAME, sql);
		return this.baseDao.deleteBySql(mapper, params);
	}

	@Override
	public int update(T t) throws Exception {
		return this.baseDao.update(mapper, clazz, t);
	}

	@Override
	public int updateBySql(String sql, Map<String, Object> params) throws Exception {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		params.put(BaseDaoImpl.SQL_NAME, sql);
		return this.baseDao.updateBySql(mapper, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Serializable id) throws Exception {
		return (T) this.baseDao.get(mapper, clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getOne(T t) throws Exception {
		return (T) this.baseDao.getOne(mapper, clazz, t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(String sql, Map<String, Object> params) throws Exception {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		params.put(BaseDaoImpl.SQL_NAME, sql);
		return (List<T>) this.baseDao.getList(mapper, params);
	}

	@Override
	public List<T> getListByOne(T t) throws Exception {
		return getListByOne(t, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getListByOne(T t, Map<String, Boolean> orderBy) throws Exception {
		return (List<T>) this.baseDao.getListByOne(mapper, clazz, t, orderBy);
	}

	@Override
	public Long getCountByOne(T t) throws Exception {
		return getCountByOne(t, null);
	}

	@Override
	public Long getCountByOne(T t, Map<String, Boolean> orderBy) throws Exception {
		return this.baseDao.getTotalSize(mapper, clazz, t, orderBy);
	}

	@Override
	public Long getCountBySql(String sql, Map<String, Object> params) throws Exception {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		params.put(BaseDaoImpl.SQL_NAME, sql);
		return this.baseDao.getCountBySql(mapper, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getPageList(T t, int p, int size) throws Exception {
		return (List<T>) this.baseDao.getList(mapper, clazz, t, p, size);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> getPageList(Page<T> page) throws Exception {
		return (Page<T>) this.baseDao.getPageList(mapper, clazz, (Page<Object>) page, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> getPageList(Page<T> page, Map<String, Boolean> orderBy) throws Exception {
		return (Page<T>) this.baseDao.getPageList(mapper, clazz, (Page<Object>) page, orderBy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> getPageList(Page<T> page, Map<String, Boolean> orderBy, String tableName) throws Exception {
		return (Page<T>) this.baseDao.getPageList(mapper, clazz, (Page<Object>) page, orderBy, tableName);
	}

	@Override
	public Map<String, Object> getMapResult(String sql, Map<String, Object> params) throws Exception {
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		params.put(BaseDaoImpl.SQL_NAME, sql);
		return this.baseDao.getMapResult(mapper, params);
	}

}
