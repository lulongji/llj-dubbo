package com.lu.common.mybatis.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.lu.common.mybatis.Page;

public interface IBaseService<T> {
	 int insert(T t) throws Exception;

	 int insertBySql(String sql,Map<String, Object> map) throws Exception;
	
	 int delete(Serializable id) throws Exception;
	 int deleteBySql(String sql,Map<String, Object> map) throws Exception;
	
	 int update(T t) throws Exception;
	 int updateBySql(String sql,Map<String, Object> map) throws Exception;
	
	 T get(Serializable id) throws Exception;
	/**
	 * 针对具有唯一性的数据来查询，若有多条数据会抛异常
	 * @param t
	 * @return
	 * @throws Exception
	 */
	 T getOne(T t) throws Exception;
	 List<T> getList(String sql,Map<String,Object> map) throws Exception;
	 List<T> getListByOne(T t) throws Exception;
	 List<T> getListByOne(T t,Map<String,Boolean> orderBy) throws Exception;
	
	 Long getCountByOne(T t) throws Exception;
	 Long getCountByOne(T t,Map<String,Boolean> orderBy) throws Exception;
	 Long getCountBySql(String sql,Map<String,Object> map) throws Exception;
	 
	/**
	 * 
	 * @param t
	 * @param p  当前页
	 * @param size 每页条数
	 * @return
	 * @throws Exception
	 */
	 List<T> getPageList(T t,int p,int size) throws Exception;
	
	 Page<T> getPageList(Page<T> page) throws Exception;
	
	 Page<T> getPageList(Page<T> page,Map<String,Boolean> orderBy) throws Exception;
	 Page<T> getPageList(Page<T> page,Map<String,Boolean> orderBy,String tableName) throws Exception;
	
	 Map<String,Object> getMapResult(String sql,Map<String,Object> map) throws Exception;
	

}
