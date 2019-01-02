package org.qhs.myproduct.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description
 * @date 2018/11/12
 */
@Configuration
public class QueueConfig {
	@Value("${queue}")
	private String queueName;

	@Bean
	public Queue LogQueue(){
		return new ActiveMQQueue(queueName);
	}
}
