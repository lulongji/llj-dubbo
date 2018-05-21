package com.lu;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.mapping.GetMapping;
import io.searchbox.indices.mapping.PutMapping;

/**
 * es
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年7月8日 上午10:29:05
 */
public class EsAdvancedService {
	private static Logger logger = LoggerFactory.getLogger(EsAdvancedService.class);

	/**
	 * 创建索引
	 * 
	 * @param indexName
	 * @return
	 */
	public static boolean createIndex(String indexName) {
		CreateIndex createIndex = new CreateIndex.Builder(indexName).build();
		try {
			JestResult result = ESFactory.getClient().execute(createIndex);
			if (result == null || !result.isSucceeded()) {
				throw new Exception(result.getErrorMessage() + "创建索引失败!");
			}
		} catch (Exception e) {
			logger.error("", e);
			return false;
		}
		return true;
	}

	public static JestResult get(String indexName, String query) {
		Get get = new Get.Builder(indexName, query).build();
		JestResult rs = null;
		try {
			rs = ESFactory.getClient().execute(get);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 手动创建类型(map一旦定义创建，field只能新增，不能修改)
	 * 
	 * @param indexName
	 * @param indexType
	 * @param mappingString
	 * @return
	 */
	public static boolean createType(String indexName, String indexType, String mappingString) {
		PutMapping.Builder builder = new PutMapping.Builder(indexName, indexType, mappingString);
		builder.refresh(true);
		try {
			JestResult result = ESFactory.getClient().execute(builder.build());
			if (result == null || !result.isSucceeded()) {
				throw new RuntimeException(result.getErrorMessage() + "创建索引类型失败!");
			}
		} catch (Exception e) {
			logger.error("", e);
			return false;
		}
		return true;
	}

	/**
	 * 获取索引类型mapping
	 * 
	 * @param typeName
	 *            类型名称
	 * @return
	 */
	public static String getMapping(String indexName, String typeName) {
		GetMapping.Builder builder = new GetMapping.Builder();
		builder.addIndex(indexName).addType(typeName);
		try {
			JestResult result = ESFactory.getClient().execute(builder.build());
			if (result != null && result.isSucceeded()) {
				return result.getSourceAsObject(JsonObject.class).toString();
			}
			logger.error("es get mapping Exception ", result.getErrorMessage());
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	/**
	 * 删除文档
	 * 
	 * @param indexId
	 * @param indexName
	 * @param indexType
	 */
	public static boolean deleteDoc(String indexId, String indexName, String indexType) {
		Delete.Builder builder = new Delete.Builder(indexId);
		builder.refresh(true);
		Delete delete = builder.index(indexName).type(indexType).build();
		try {
			JestResult result = ESFactory.getClient().execute(delete);
			if (result != null && !result.isSucceeded()) {
				throw new RuntimeException(result.getErrorMessage() + "删除文档失败!");
			}
		} catch (Exception e) {
			logger.error("", e);
			return false;
		}
		return true;
	}

	/**
	 * 删除类型
	 * 
	 * @param indexId
	 * @param indexName
	 * @param indexType
	 */
	public static boolean deleteType(String indexName, String indexType) {
		DeleteIndex dIndex = new DeleteIndex.Builder(indexName).type(indexType).build();
		try {
			JestResult result = ESFactory.getClient().execute(dIndex);
			if (result != null && result.isSucceeded()) {
				throw new RuntimeException(result.getErrorMessage() + "删除类型失败!");
			}
		} catch (Exception e) {
			logger.error("", e);
			return false;
		}
		return true;
	}

	/**
	 * 删除索引
	 * 
	 * @param indexId
	 * @param indexName
	 * @param indexType
	 */
	public static boolean deleteIndex(String indexName) {
		DeleteIndex dIndex = new DeleteIndex.Builder(indexName).build();
		try {
			JestResult result = ESFactory.getClient().execute(dIndex);
			if (result != null && result.isSucceeded()) {
				return true;
			}
		} catch (Exception e) {
			logger.error("", e);
			return false;
		}
		return false;
	}

	/**
	 * 插入或更新文档
	 * 
	 * @param indexId
	 * @param indexObject
	 * @param indexName
	 * @param indexType
	 * @return
	 */
	public static boolean insertOrUpdateDoc(String indexId, Object indexObject, String indexName, String indexType) {
		Index.Builder builder = new Index.Builder(indexObject);
		builder.id(indexId);
		builder.refresh(true);
		Index index = builder.index(indexName).type(indexType).build();
		try {
			JestResult result = ESFactory.getClient().execute(index);
			if (result != null && !result.isSucceeded()) {
				throw new RuntimeException(result.getErrorMessage() + "插入更新索引失败!");
			}
		} catch (Exception e) {
			logger.error("", e);
			return false;
		}
		return true;
	}

	/**
	 * 通过一次查询就可获取查询的结果（分页）及总条数
	 * 
	 * @param classType
	 * @param indexName
	 * @param indexType
	 * @param esQuery
	 * @return
	 */
	public static EsResult search(String indexName, String indexType, EsQuery esQuery) {
		EsResult result = new EsResult();
		try {
			Search search = new Search.Builder(esQuery.getQueryString()).addIndex(indexName).addType(indexType).build();
			JestResult jestResult = ESFactory.getClient().execute(search);
			System.out.println(jestResult.getJsonObject());
			JsonElement element = jestResult.getJsonObject().get("hits");
			int hitCount = element.getAsJsonObject().get("total").getAsInt();
			JsonArray array = element.getAsJsonObject().get("hits").getAsJsonArray();

			result.setTotal(hitCount);
			result.setResult(array);
		} catch (Exception e) {
			logger.error("查询失败", e);
		}
		return result;
	}
}
