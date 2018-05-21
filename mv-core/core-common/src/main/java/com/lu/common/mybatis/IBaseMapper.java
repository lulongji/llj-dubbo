package com.lu.common.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基础操作mapper
 * 
 * @author lu
 */
public interface IBaseMapper {
	 int insert(Object obj) throws Exception;

	 int insertBySql(Map<String, Object> map) throws Exception;

	 int update(Map<String, Object> map) throws Exception;

	 int updateAllField(Object obj) throws Exception;

	 int updateByObj(Object obj) throws Exception;

	 Object getFirstByObj(Object obj) throws Exception;

	 List<Object> getListAll() throws Exception;

	 List<Object> getListByObj(Object obj) throws Exception;

	 List<Object> getListByObjPage(Object obj) throws Exception;

	 Map<String, Object> selectMap(Map<String, Object> map) throws Exception;

	 List<Object> select(Map<String, Object> map) throws Exception;

	 Long getCountByObj(Object obj) throws Exception;

	 Long selectCount(Map<String, Object> map) throws Exception;

	 int delete(Map<String, Object> map) throws Exception;

	 int deleteByObj(Object obj) throws Exception;

	 int deleteAttrByIdList(List<Serializable> ids) throws Exception;

}
