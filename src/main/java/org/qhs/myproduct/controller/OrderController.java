//package org.qhs.myproduct.controller;
//
//import org.qhs.myproduct.dto.ResultJSON;
//import org.qhs.myproduct.exception.ServiceException;
//import org.qhs.myproduct.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author QianHuaSheng
// * @version V1.0
// * @description 订单控制类
// * @date 2018/11/17
// */
//@RestController
//public class OrderController {
//
//	@Autowired
////	private OrderService orderService;
//
////	@Autowired
////	private TestAbstract testAbstract;
//
//	@RequestMapping("/order/query_orders")
//	public ResultJSON queryOrders() throws ServiceException {
//		return new ResultJSON().success("获取订单记录成功", orderService.queryOrder("测试"));
//	}
//
//	@RequestMapping("/order/insert_orders")
//	public ResultJSON insertOrders() throws ServiceException {
//		orderService.saveOrder("测试");
//		return new ResultJSON().success("保存订单成功");
//	}
//
//	@RequestMapping("/order/test")
//	public ResultJSON test() throws ServiceException {
//		orderService.testTransactional();
//		return new ResultJSON().success("保存订单成功");
//	}
//
//	@RequestMapping("/test/abstract")
//	public ResultJSON testAbstract() throws ServiceException {
////		orderService.testAbstract();
//		return new ResultJSON().success("保存订单成功");
//	}
//}
