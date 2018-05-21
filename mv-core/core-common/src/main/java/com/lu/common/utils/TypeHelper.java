package com.lu.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 类型帮助类
 * 
 * @author lu
 */
public class TypeHelper {
	/**
	 * 是否为泛型类型
	 * 
	 * @param type
	 * @return
	 */
	public static boolean isGenerics(Type type) {
		if (type instanceof ParameterizedType)
			return true;
		return false;
	}

	/**
	 * 是否为原生类型
	 * 
	 * @param clazz
	 * @return {@link Boolean} <code>true</code>原生类型，<code>false</code>非原生类型
	 */
	public static boolean isPrimitive(Class<?> clazz) {
		if (clazz.isPrimitive())
			return true;
		if (Byte.class == clazz || Character.class == clazz || Short.class == clazz || Integer.class == clazz || Long.class == clazz || Float.class == clazz || Double.class == clazz)
			return true;
		return false;
	}

	/**
	 * 是否为数组
	 * 
	 * @param clazz
	 * @return {@link Boolean} <code>true</code>数组类型，<code>false</code>非数组类型
	 */
	public static boolean isArray(Class<?> clazz) {
		if (clazz.isArray())
			return true;
		return false;
	}

	/**
	 * 是否为字符串
	 * 
	 * @param clazz
	 * @return {@link Boolean} <code>true</code>字符串类型，<code>false</code>非字符串类型
	 */
	public static boolean isString(Class<?> clazz) {
		if (String.class == clazz)
			return true;
		return false;
	}

	/**
	 * 是否为嵌入类型
	 * 
	 * @param clazz
	 * @return
	 */
	public static boolean isEmbed(Class<?> clazz) {
		if (Object.class.isAssignableFrom(clazz))
			return true;
		return false;
	}

	/**
	 * 是否为枚举
	 * 
	 * @param clazz
	 * @return
	 */
	public static boolean isEnum(Class<?> clazz) {
		if (clazz.isEnum())
			return true;
		return false;
	}
}
