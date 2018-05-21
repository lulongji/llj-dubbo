package com.lu.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 时间简单用法
 * 
 * @author lu
 */
public class SimpleTimeUsage {

	private static String FORMAT = "yyyy-MM-dd HH:mm:ss";

	private static DateFormat df = new SimpleDateFormat(FORMAT);

	/**
	 * 返回时间对应的毫秒
	 * 
	 * @param unit
	 * @param delay
	 * @return
	 */
	public static long toMiliseconds(TimeUnit unit, long delay) {
		return unit.toMillis(delay);
	}

	/**
	 * 返回对应的秒
	 * 
	 * @param unit
	 * @param delay
	 * @return
	 */
	public static long toSeconds(TimeUnit unit, int delay) {
		return unit.toSeconds(delay);
	}

	/**
	 * 返回时间戳字符串
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String toTimeStr(long timestamp) {
		return df.format(new Date(timestamp));
	}
}