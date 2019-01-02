package org.qhs.myproduct.customer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description 消费者
 * @date 2018/11/11
 */
public class Customer {

	public static void main(String[] args) throws JMSException {
		Connection connection = null;
		try {
			ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
			connection = activeMQConnectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
			Queue destination  = session.createQueue("my-product1");
			MessageConsumer consumer = session.createConsumer(destination);
			while(1==1){
				TextMessage receive = (TextMessage) consumer.receive();
				receive.acknowledge();
				System.out.println("接受消息成功"+receive.getText());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}
}
