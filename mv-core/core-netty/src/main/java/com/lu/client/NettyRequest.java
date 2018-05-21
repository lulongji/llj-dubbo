package com.lu.client;

/**
 * NettyRequest
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年7月8日 上午10:10:35
 */
final public class NettyRequest {
	private final long messageId;
	private final byte[] request;

	public NettyRequest(long messageId, byte[] request) {
		this.messageId = messageId;
		this.request = request;
	}

	public long getMessageId() {
		return messageId;
	}

	public byte[] getRequest() {
		return request;
	}
}
