package com.lu.client;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * MessageQueue
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年7月8日 上午10:10:28
 */
public class MessageQueue {
	private static Map<Long, Data> map = new HashMap<>();

	public static void put(Long messageId) {
		map.put(messageId, new Data());
	}

	public static void put(Long messageId, byte[] data) {
		if (map.containsKey(messageId)) {
			Data datas = map.get(messageId);
			datas.setResult(data);
			datas.countDown();
		}
	}

	public static byte[] get(Long messageId, int timeout) throws TimeoutException, InterruptedException {
		byte[] result = null;
		try {
			map.get(messageId).await(timeout);
			// if (!latch.await(timeout, TimeUnit.SECONDS)) {
			// throw new TimeoutException();
			// }
			result = map.get(messageId).getResult();
		} finally {
			map.remove(messageId);
		}
		return result;
	}

	private static class Data {
		private byte[] result;
		private CountDownLatch latch;

		public Data() {
			this.result = null;
			this.latch = new CountDownLatch(1);
		}

		public byte[] getResult() {
			return result;
		}

		public void setResult(byte[] result) {
			this.result = result;
		}

		public void countDown() {
			latch.countDown();
		}

		public boolean await(int timeoutSecond) throws TimeoutException, InterruptedException {
			return latch.await(timeoutSecond, TimeUnit.SECONDS);
		}
	}
}
