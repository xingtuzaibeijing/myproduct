package org.qhs.myproduct.service;

import org.qhs.myproduct.entity.EntityOrder;
import org.qhs.myproduct.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {
	List<EntityOrder> queryOrder(String rname) throws ServiceException;

	void saveOrder(String rname) throws ServiceException;

	@Transactional
	void testTransactional() throws ServiceException;

	default String myOldName(){
		return "chao";
	}
}
