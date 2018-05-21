package com.lu.netty5.handler;

import com.lu.common.log.Logger;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Heartbeat
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年7月8日 上午10:16:56
 */
public abstract class Heartbeat extends ChannelHandlerAdapter {

	Logger log = Logger.getLogger(Heartbeat.class);

	// 利用写空闲发送心跳检测消息
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			switch (e.state()) {
			case WRITER_IDLE:
				ctx.writeAndFlush(getPing());
				break;
			default:
				break;
			}
			log.debug("send heartbeat……");
		}
	}

	public abstract byte[] getPing();
}
