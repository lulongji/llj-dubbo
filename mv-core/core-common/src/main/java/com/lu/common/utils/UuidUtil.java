package com.lu.common.utils;

import java.util.UUID;

/**
 * 创建UUID
 * 
 * @author lu
 *
 */
public class UuidUtil {

	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	public static void main(String[] args) {
		System.out.println(get32UUID());
	}
}
