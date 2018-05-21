package com.lu.common.utils;

/**
 * 钩子
 * 
 * @author lu
 * 
 */
public class ShutdownHook {
	/**
	 * 添加钩子
	 * 
	 * @param runner
	 */
	public static void addHook(Runnable runner) {
		Runtime.getRuntime().addShutdownHook(new Thread(runner));
	}

	/**
	 * 移除钩子
	 * 
	 * @param runner
	 */
	public static void removeHook(Runnable runner) {
		Runtime.getRuntime().removeShutdownHook(new Thread(runner));
	}
}
