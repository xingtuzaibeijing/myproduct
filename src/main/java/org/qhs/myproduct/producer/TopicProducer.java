package org.qhs.myproduct.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

/**
 * @author QianHuaSheng
 * @version V1.0
 * @description 生产者
 * @date 2018/11/11
 */
public class TopicProducer {
	public static void main(String[] args) throws JMSException {

		ActiveMQConnectionFactory activeMQConnectionFactory;
		Connection connection = null;
		try {
			activeMQConnectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://127.0.0.1:61616");
			connection = activeMQConnectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(Boolean.FALSE, Session.CLIENT_ACKNOWLEDGE);
			Topic topic = session.createTopic("my-topic");
			MessageProducer producer = session.createProducer(topic);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			for (int i = 0, len = 5; i < len; i++) {
				Message message = session.createTextMessage("今天是个好日子" + i);
				System.out.println("生产消息成功："+"今天是个好日子" + i);
				producer.send(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}
