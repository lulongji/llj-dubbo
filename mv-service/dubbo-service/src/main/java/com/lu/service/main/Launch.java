/**
 * 
 */
package com.lu.service.main;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lu.common.log.Logger;

/**
 * 启动dubbo服务
 * 
 * @author lu
 *
 */
public class Launch {

	protected static Logger logger = Logger.getLogger(Launch.class);

	private static volatile boolean running = true; // 运行状态

	public static void main(String[] args) throws IOException {

		final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/*.xml");

		// 增加一个停止钩子，用于关闭spring
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					context.stop();
					context.close();
					logger.info("Service dubbo-service stopped...");
					System.out.println("Service dubbo-service stopped...");
				} catch (Exception t) {
					logger.error(t.getMessage(), t);
				}
				synchronized (Launch.class) {
					running = false;
					Launch.class.notify();
				}
			}

		});

		// 启动spring
		context.start();
		logger.info("Service dubbo-service started...");
		System.out.println("Service dubbo-service started...");

		// 进入等待状态
		synchronized (Launch.class) {
			while (running) {
				try {
					Launch.class.wait();
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}

}
