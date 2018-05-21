package com.lu.netty5.pool;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.lu.client.MessageQueue;
import com.lu.client.NettyRequest;
import com.lu.codec.Decoder;
import com.lu.codec.Encoder;
import com.lu.common.log.Logger;
import com.lu.common.spring.SpringContextUtil;
import com.lu.netty5.handler.NettyClientHandler;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * pool
 * 
 * @author LongJi.LU (lulongji2011@163.com)
 * @version 2016年7月8日 上午10:16:18
 */
public class NettyChannelPool {
	Logger log = Logger.getLogger(NettyChannelPool.class);

	private static LinkedBlockingQueue<SocketChannel> poolChannels;
	private Semaphore maxRoute;
	private static int connectTimeOutInMilliSecondes = 300;
	private volatile EventLoopGroup workerGroup;
	private volatile Bootstrap clientBootstrap;
	private String host;
	private int port;
	private int maxSize;

	public NettyChannelPool() {
		poolChannels = new LinkedBlockingQueue<SocketChannel>();
		clientBootstrap = new Bootstrap();
		workerGroup = new NioEventLoopGroup();
	}

	public void init() {

		maxRoute = new Semaphore(maxSize);
		clientBootstrap.group(workerGroup).channel(NioSocketChannel.class).option(ChannelOption.SO_KEEPALIVE, true).option(ChannelOption.TCP_NODELAY, true).remoteAddress(host, port)
				.handler(new ChannelInitializer<SocketChannel>() {
					@Override
					protected void initChannel(SocketChannel socketChannel) throws Exception {
						ChannelPipeline p = socketChannel.pipeline();
						// p.addLast("log", new LoggingHandler(LogLevel.DEBUG));
						p.addLast(SpringContextUtil.getBean(Encoder.class));
						p.addLast(SpringContextUtil.getBean(Decoder.class));
						p.addLast(new IdleStateHandler(10, 5, 0, TimeUnit.SECONDS));
						// p.addLast("heartbeatHandler",
						// SpringContextUtil.getBean(Heartbeat.class));
						p.addLast(SpringContextUtil.getBean(NettyClientHandler.class));
					}
				});
	}

	public byte[] sendAndRecive(final NettyRequest request) throws InterruptedException, IOException, TimeoutException {
		MessageQueue.put(request.getMessageId());
		if (sendRequestUsePooledChannel(request, false)) {
			log.info("使用队列channel发送");
			return MessageQueue.get(request.getMessageId(), 5);
		}
		if (sendRequestUseNewChannel(request)) {
			log.info("使用新channel发送");
			return MessageQueue.get(request.getMessageId(), 5);
		}
		if (sendRequestUsePooledChannel(request, true)) {
			log.info("等待队列channel发送");
			return MessageQueue.get(request.getMessageId(), 5);
		}
		throw new IOException("send request failed");
	}

	public void send(final NettyRequest request) throws InterruptedException, IOException, TimeoutException {
		if (sendRequestUsePooledChannel(request, false)) {
			return;
		}
		if (sendRequestUseNewChannel(request)) {
			return;
		}
		if (sendRequestUsePooledChannel(request, true)) {
			return;
		}
		throw new IOException("send request failed");
	}

	public void returnChannel(SocketChannel channel) {
		if (null != channel && channel.isActive()) {
			if (poolChannels.offer(channel)) {
				log.debug(channel + "returned");
			}
		}
	}

	public void close() throws InterruptedException {
		ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
		for (Channel channel : poolChannels) {
			channelGroup.add(channel);
		}
		channelGroup.close().sync();
		workerGroup.shutdownGracefully();
	}

	private boolean sendRequestUsePooledChannel(final NettyRequest request, boolean isWaiting) throws InterruptedException {
		log.info("队列长度{}:" + poolChannels.size());
		SocketChannel channel = poolChannels.poll();
		while (null != channel && !channel.isActive()) {
			channel = poolChannels.poll();
		}
		if (null == channel || !channel.isActive()) {
			if (!isWaiting) {
				return false;
			}
			channel = poolChannels.poll(connectTimeOutInMilliSecondes, TimeUnit.MILLISECONDS);
			if (null == channel || !channel.isActive()) {
				log.warn("obtain channel from pool timeout");
				return false;
			}
		}

		log.debug(channel + " reuse");
		channel.writeAndFlush(request.getRequest());
		returnChannel(channel);
		return true;
	}

	private boolean sendRequestUseNewChannel(final NettyRequest request) {
		ChannelFuture future = createChannelFuture();
		if (null != future && future.isSuccess()) {
			SocketChannel channel = (SocketChannel) future.channel();
			channel.writeAndFlush(request.getRequest());
			returnChannel(channel);
			return true;
		}
		log.error(future.channel() + " connect failed, exception: " + future.cause());
		return false;
	}

	private ChannelFuture createChannelFuture() {
		if (maxRoute.tryAcquire()) {
			try {
				ChannelFuture connectFuture = clientBootstrap.connect(host, port).sync();
				return connectFuture;
			} catch (Exception e) {
				log.error("connect failed", e);
				maxRoute.release();
			}
		}
		return null;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
}
