package com.lu.common.mongo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.lu.common.mongo.entity.MongoEntity;
import com.lu.common.mybatis.Page;

/**
 * BasicDAO<T extends Entity,PK > 这里强制子类必须继承Entity采用公共的方法，用于检查子类是否继承，PK仅代表主键
 * 备注：此类中所有的方法基本是针对MongoOperations中的 方法的简单调用，便于子类的直接实现
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年6月22日 下午4:43:48
 * @param <T>
 * @param <PK>
 */
public abstract class AbstractBasicDao<T extends MongoEntity, PK> implements IMongoDao<T, PK> {
	@Resource
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public void createCollection(String tableName) {
		mongoTemplate.createCollection(tableName);
	}

	@Override
	public boolean collectionExists(String tableName) {
		return mongoTemplate.collectionExists(tableName);
	}

	@Override
	public void dropCollection(String tableName) {
		mongoTemplate.dropCollection(tableName);
	}

	@Override
	public T findById(String id, Class<T> clazz) {
		return mongoTemplate.findById(id, clazz);
	}

	public T findOne(Criteria criteria, Class<T> clazz) {
		return mongoTemplate.findOne(new Query(criteria), clazz);
	}

	@Override
	public T findOne(String tableName, Query query, Class<T> clazz) {
		return mongoTemplate.findOne(query, clazz, tableName);
	}

	@Override
	public T findOne(Query query, Class<T> clazz) {
		return mongoTemplate.findOne(query, clazz);
	}

	@Override
	public T findOne(String tableName, Criteria criteria, Class<T> clazz) {
		return findOne(tableName, new Query(criteria), clazz);
	}

	@Override
	public List<T> findList(Criteria criteria, Class<T> clazz) {
		return mongoTemplate.find(new Query(criteria), clazz);
	}

	@Override
	public List<T> findAll(Class<T> clazz) {
		return this.mongoTemplate.findAll(clazz);
	}

	@Override
	public List<T> findList(Query query, Class<T> clazz) {
		return mongoTemplate.find(query, clazz);
	}

	@Override
	public T findAndRemove(Query query, Class<T> clazz) {
		return mongoTemplate.findAndRemove(query, clazz);
	}

	@Override
	public T findAndRemove(Criteria criteria, Class<T> clazz) {
		return mongoTemplate.findAndRemove(new Query(criteria), clazz);
	}

	@Override
	public void remove(String tableName, Criteria criteria, Class<T> clazz) {
		mongoTemplate.remove(new Query(criteria), clazz);
	}

	@Override
	public void remove(T entity) {
		mongoTemplate.remove(entity);
	}

	@Override
	public long size(Criteria criteria, Class<T> clazz) {
		return mongoTemplate.count(new Query(criteria), clazz);
	}

	@Override
	public long size(Query query, Class<T> clazz) {
		return mongoTemplate.count(query, clazz);
	}

	@Override
	public void save(String tableName, T entity) {
		mongoTemplate.save(entity, tableName);
	}

	@Override
	public void save(T entity) {
		mongoTemplate.save(entity);
	}

	@Override
	public void insert(T entity) {
		mongoTemplate.insert(entity);
	}

	@Override
	public void insertBatch(List<T> entitys, Class<T> clazz) {
		mongoTemplate.insert(entitys, clazz);
	}

	@Override
	public void update(Query query, Update update, Class<T> clazz) {
		this.mongoTemplate.updateMulti(query, update, clazz);
	}

	@Override
	public void update(Query query, Update update, String tableName) {
		this.mongoTemplate.updateMulti(query, update, tableName);
	}

	@Override
	public void findAndModify(Query query, Update update, Class<T> clazz) {
		this.mongoTemplate.findAndModify(query, update, clazz);
	}

	@Override
	public void findAndModify(Query query, Update update, Class<T> clazz, String tableName) {
		this.mongoTemplate.findAndModify(query, update, clazz, tableName);
	}

	@Override
	public Page<T> limitFind(int pageSize, int forward, Class<T> clazz) {
		Query query = new Query();
		return limitFind(pageSize, forward, query, clazz);
	}

	@Override
	public Page<T> limitFind(Query query, Page<T> page, Class<T> clazz) {
		long size = page.getTotalRecord();
		if (size == 0l) {
			size = size(query, clazz);
			if (size == 0) {
				return page;
			}
			page.setTotalRecord((int) size);
		}
		query.skip(page.getBeginRow()).limit(page.getPageSize());
		List<T> list = findList(query, clazz);
		page.setResult(list);
		return page;
	}

	@Override
	public Page<T> limitFind(int pageSize, int forward, Query query, Class<T> clazz) {
		Page<T> page = new Page<T>();
		page.setCurrentPageNo(forward);
		page.setPageSize(pageSize);
		return limitFind(query, page, clazz);
	}

	/**
	 * @function 更新
	 * @param query
	 * @param update
	 * @param clazz
	 */
	@Override
	public void update(String whereKey, Object whereValue, String updateKey, Object updateValue, Class<T> clazz) {
		update(new Query(Criteria.where(whereKey).is(whereValue)), Update.update(updateKey, updateValue), clazz);
	}

}
