//package org.qhs.myproduct.producer;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.jms.Queue;
//
///**
// * @author QianHuaSheng
// * @version V1.0
// * @description
// * @date 2018/11/12
// */
//@Component
//public class SpringBootProducer {
//	@Autowired
//	private Queue queue;
//
//	@Autowired
//	private JmsMessagingTemplate jmsMessagingTemplate;
//
//	private static Integer count=0;
//
//	@Scheduled(fixedDelay  = 5000)
//	public void producer(){
//		jmsMessagingTemplate.convertAndSend(queue,"测试数据count："+count);
//		count++;
//	}
//}
