/**
 * 鲁龙基个人版权所有
 * Copyright (C)   2016 - 2020 Corporation. All Rights Reserved
 */
package com.lu.common.test.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式 (单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例)
 * 
 * 线程池、缓存、日志对象、对话框、打印机、显卡的驱动程序对象常被设计成单例
 * 
 * 单例模式就是为了避免不一致状态，避免政出多头
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年6月13日 下午3:19:06
 */

// 一个类只能有一个实例
// 必须是自己创建自己的唯一实例
// 必须给所有其他对象提供这个实例

// 饿汉式 在类的初始化的时候已经自动实例化
class Singleton {

	// 构造方法
	private Singleton() {

	}

	// 已经自行实例化
	private static final Singleton s = new Singleton();

	// 静态工厂模式
	public static Singleton getInstance() {
		return s;
	}
}

// 懒汉式 在第一次调用的时候实例化
class Singleton2 {
	// 构造方法
	private Singleton2() {

	}

	// 初始化类
	private static Singleton2 s = null;

	// 静态工厂模式
	public static Singleton2 getInstance() {
		if (s == null) {
			s = new Singleton2();
		}
		return s;
	}

}

// 登记式 类似Spring里面的方法，将类名注册，下次从里面直接获取。
class Singleton3 {
	private static Map<String, Singleton3> map = new HashMap<String, Singleton3>();
	static {
		Singleton3 single = new Singleton3();
		map.put(single.getClass().getName(), single);
	}

	// 保护的默认构造子
	protected Singleton3() {
	}

	// 静态工厂方法,返还此类惟一的实例
	public static Singleton3 getInstance(String name) {
		if (name == null) {
			name = Singleton3.class.getName();
			System.out.println("name == null" + "--->name=" + name);
		}
		if (map.get(name) == null) {
			try {
				map.put(name, (Singleton3) Class.forName(name).newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return map.get(name);
	}

	// 一个示意性的商业方法
	public String about() {
		return "Hello, I am RegSingleton.";
	}

	public static void main(String[] args) {
		Singleton3 single3 = Singleton3.getInstance(null);
		System.out.println(single3.about());
	}

}

// 懒汉式 改进 用这种方式解决了懒汉式的线程安全问题，也提高了效率，但是在实际开发中还是用饿汉式的比较多，毕竟这个代码比较多，比较繁琐。
class Singleton2a {
	private Singleton2a() {

	}

	public static Singleton2a s = null;

	public static Singleton2a getInstance() {
		if (s == null) {
			synchronized (Singleton2a.class) {
				if (s == null) {
					s = new Singleton2a();
				}
			}
		}
		return s;
	}

}