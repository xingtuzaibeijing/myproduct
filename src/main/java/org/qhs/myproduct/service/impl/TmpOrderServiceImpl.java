//package org.qhs.myproduct.service.impl;
//
//import org.qhs.myproduct.entity.EntityOrder;
//import org.qhs.myproduct.enums.ExceptionEnum;
//import org.qhs.myproduct.exception.ServiceException;
//import org.qhs.myproduct.mapper.OrderMapper;
//import org.qhs.myproduct.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.StringUtils;
//import tk.mybatis.mapper.entity.Example;
//
//import java.util.List;
//
///**
// * @author QianHuaSheng
// * @version V1.0
// * @description 订单
// * @date 2018/11/17
// */
//@Service
//public class TmpOrderServiceImpl implements OrderService {
//	@Autowired
//	private OrderMapper orderMapper;
//
//	@Override
//	public List<EntityOrder> queryOrder(String rname) throws ServiceException {
//		//校验参数是否正确
//		if (StringUtils.isEmpty(rname)) {
//			throw new ServiceException(ExceptionEnum.BAD_REQUEST.type, "无效的");
//		}
//		//构建example
//		Example example = new Example(EntityOrder.class);
//		Example.Criteria criteria = example.createCriteria();
//		EntityOrder order = new EntityOrder();
//		order.setRname(rname);
//		criteria.andEqualTo(order);
//		//查询
//		List<EntityOrder> entityOrders = orderMapper.selectByExample(example);
//		return entityOrders;
//	}
//
//
//	@Override
//	public void saveOrder(String rname) throws ServiceException {
//		//检验
//		if (StringUtils.isEmpty(rname)) {
//			throw new ServiceException(ExceptionEnum.BAD_REQUEST.type, "订单名称为空");
//		}
//		//构造
//		EntityOrder order = new EntityOrder();
//		order.setRid(1);
//		order.setRname(rname);
//		//保存
//		orderMapper.insert(order);
//	}
//
//
////	@Override
////	@Transactional
////	public void testTransactional() throws ServiceException {
////		//外部保存
////		//构造
////		EntityOrder order = new EntityOrder();
////		order.setRname("外部保存");
////		order.setRid(1);
////		//保存
////		orderMapper.insert(order);
////		saveInside();
////
////	}
//
//	@Transactional
//	public void saveInside() {
//		//内部保存
//		//构造
//		EntityOrder order = new EntityOrder();
//		order.setRname("内部保存");
//		order.setRid(2);
//		//保存
//		orderMapper.insert(order);
//		int i = 1 / 0;
//	}
//}
