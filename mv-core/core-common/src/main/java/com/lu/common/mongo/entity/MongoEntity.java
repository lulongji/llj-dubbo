package com.lu.common.mongo.entity;

import java.io.Serializable;

import com.lu.common.utils.JsonUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年6月22日 下午4:42:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MongoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return JsonUtil.bean2json(this);
	}

}
