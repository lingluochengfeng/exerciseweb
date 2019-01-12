package com.usst.exerciseweb.ordermgr.service;


import com.usst.exerciseweb.common.service.impl.IBaseServiceImpl;
import com.usst.exerciseweb.ordermgr.dao.OrderDetailDAO;
import com.usst.exerciseweb.ordermgr.vo.OrderDetailModel;
import com.usst.exerciseweb.ordermgr.vo.OrderDetailQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OrderDetailService extends IBaseServiceImpl<OrderDetailModel,OrderDetailQueryModel> implements IOrderDetailService{
	private OrderDetailDAO dao = null;
	@Autowired
	private void setDao(OrderDetailDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}
	
}