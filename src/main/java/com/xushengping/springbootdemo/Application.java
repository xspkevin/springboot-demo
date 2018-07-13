/**
 * 程序主类
 * @auth Xu Shengping
 */

package com.xushengping.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

	/**
	 * 我是日志
	 */
	private final static Logger LOG = LoggerFactory.getLogger(Application.class);

	/**
	 * 程序入口
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// 启动服务
		Environment env = SpringApplication.run(Application.class, args).getEnvironment();
		LOG.info("--------------------------------");
		LOG.info("执行环境：{}", env.getProperty("spring.profiles.active"));
		LOG.info("应用名称：{}", env.getProperty("spring.application.name"));
		LOG.info("执行端口：{}", env.getProperty("server.port"));
		LOG.info("--------------------------------");
	}
}
