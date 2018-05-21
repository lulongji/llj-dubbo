/**
 * 鲁龙基个人版权所有
 * Copyright (C)   2016 - 2020 Corporation. All Rights Reserved
 */
package com.lu.common.test.demo.algorithm;

import java.math.BigDecimal;

/**
 * 
 * 阶乘 n!=n*(n-1)!
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年6月13日 下午5:06:57
 */
public class Factorial {

	/**
	 * 阶乘第一种 multiply for循环
	 * 
	 * @return
	 */
	public static BigDecimal Factoriala1(int n) {
		BigDecimal b;
		BigDecimal result = new BigDecimal(1);
		for (int i = 1; i <= n; i++) {
			b = new BigDecimal(i);
			result = result.multiply(b);
		}
		return result;
	}

	/**
	 * 阶乘 第二种 while
	 * 
	 * @param args
	 */
	public static BigDecimal Factoriala2(BigDecimal n) {
		//BigDecimal b;
		BigDecimal result = new BigDecimal(1);
		// while (n.compareTo(val)) {
		//
		// }
		return result;
	}

	/**
	 * 阶乘 第三种 递归
	 * 
	 * @param args
	 */
	public static BigDecimal Factoriala3(BigDecimal n) {
		return null;
	}

	public static void main(String[] args) {
		System.out.println(Factorial.Factoriala1(0));
	}
}
