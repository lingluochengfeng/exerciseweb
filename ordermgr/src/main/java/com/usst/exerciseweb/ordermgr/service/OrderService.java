package com.usst.exerciseweb.ordermgr.service;


import java.util.Date;

import com.usst.exerciseweb.cartmgr.service.ICartService;
import com.usst.exerciseweb.common.service.impl.IBaseServiceImpl;
import com.usst.exerciseweb.ordermgr.dao.OrderDAO;
import com.usst.exerciseweb.ordermgr.vo.OrderModel;
import com.usst.exerciseweb.ordermgr.vo.OrderQueryModel;
import com.usst.exerciseweb.storemgr.service.IStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class OrderService extends IBaseServiceImpl<OrderModel,OrderQueryModel> implements IOrderService{
	private OrderDAO dao = null;
	@Qualifier("cartService")
	@Autowired
	private ICartService ics = null;
	@Qualifier("orderDetailService")
	@Autowired
	private IOrderDetailService iods = null;
	@Qualifier("storeService")
	@Autowired
	private IStoreService iss = null;
	@Autowired
	private void setDao(OrderDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}
	public void order(int customerUuid) {

	}
	
}