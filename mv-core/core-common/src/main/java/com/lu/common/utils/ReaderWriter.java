package com.lu.common.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Type;

/**
 * 编码读写接口
 * 
 * @author lu
 */
public interface ReaderWriter {
	/**
	 * 消息读取
	 * 
	 * @param dis
	 *            数据流
	 * @param type
	 *            类型
	 * @return 字段所对应的对象
	 */
	Object read(DataInputStream dis, Type type);

	/**
	 * 将数据写入流
	 * 
	 * @param dos
	 * @param type
	 * @param value
	 */
	void write(DataOutputStream dos, Type type, Object value);
}
