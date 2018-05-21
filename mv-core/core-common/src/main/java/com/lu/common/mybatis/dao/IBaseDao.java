package com.lu.common.mybatis.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.lu.common.mybatis.IBaseMapper;
import com.lu.common.mybatis.Page;

public interface IBaseDao {
	int insert(Class<? extends IBaseMapper> mapper, Object obj) throws Exception;

	int insertBySql(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception;

	int delete(Class<? extends IBaseMapper> mapper, Class<?> clazz, Serializable id) throws Exception;

	int deleteBySql(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception;

	int update(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj) throws Exception;

	int updateBySql(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception;

	Object get(Class<? extends IBaseMapper> mapper, Class<?> clazz, Serializable id) throws Exception;

	Object getOne(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj) throws Exception;

	List<Object> getList(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception;

	List<Object> getListByOne(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj) throws Exception;

	List<Object> getListByOne(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj, Map<String, Boolean> orderBy) throws Exception;

	Long getCountBySql(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception;

	Long getTotalSize(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj) throws Exception;

	Long getTotalSize(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj, Map<String, Boolean> orderBy) throws Exception;

	Long getTotalSize(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj, String tableName) throws Exception;

	List<Object> getList(Class<? extends IBaseMapper> mapper, Class<?> clazz, Object obj, int p, int size) throws Exception;

	Page<Object> getPageList(Class<? extends IBaseMapper> mapper, Class<?> clazz, Page<Object> page, Map<String, Boolean> orderBy) throws Exception;

	Page<Object> getPageList(Class<? extends IBaseMapper> mapper, Class<?> clazz, Page<Object> page, Map<String, Boolean> orderBy, String tableName) throws Exception;

	Map<String, Object> getMapResult(Class<? extends IBaseMapper> mapper, Map<String, Object> map) throws Exception;

	SqlSessionTemplate getSessionTemplate() throws Exception;
}
