package com.lu.netty5.handler;

import com.lu.common.log.Logger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Client
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年7月8日 上午10:16:41
 */
public abstract class NettyClientHandler extends SimpleChannelInboundHandler<byte[]> {

	Logger log = Logger.getLogger(NettyClientHandler.class);

	// 利用写空闲发送心跳检测消息
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent e = (IdleStateEvent) evt;
			switch (e.state()) {
			case WRITER_IDLE:
				ctx.writeAndFlush(getPing());
				log.info("send ping to server----------");
				break;
			default:
				break;
			}
		}
	}

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, byte[] msg) throws Exception {
		result(msg);
	}

	public abstract void result(byte[] msg);

	public abstract byte[] getPing();
}
