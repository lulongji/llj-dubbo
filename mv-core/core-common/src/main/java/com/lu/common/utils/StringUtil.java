package com.lu.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 字符串相关方法
 * 
 * @author lu
 *
 */
public class StringUtil {

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * 
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr) {
		int i = 0;
		String TempStr = valStr;
		String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
		valStr = valStr + ",";
		while (valStr.indexOf(',') > 0) {
			returnStr[i] = valStr.substring(0, valStr.indexOf(','));
			valStr = valStr.substring(valStr.indexOf(',') + 1, valStr.length());

			i++;
		}
		return returnStr;
	}

	/**
	 * 将以冒号分隔的字符串转换成字符串数组
	 * 
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList2(String valStr) {
		int i = 0;
		String TempStr = valStr;
		String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(":", "").length()];
		valStr = valStr + ":";
		while (valStr.indexOf(':') > 0) {
			returnStr[i] = valStr.substring(0, valStr.indexOf(':'));
			valStr = valStr.substring(valStr.indexOf(':') + 1, valStr.length());

			i++;
		}
		return returnStr;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List list = new ArrayList<>();
		Collections.addAll(list, StrList("1111,2222"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
