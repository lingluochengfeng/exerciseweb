package com.usst.exerciseweb.ordermgr.service;


import com.usst.exerciseweb.common.service.IBaseService;
import com.usst.exerciseweb.ordermgr.vo.OrderModel;
import com.usst.exerciseweb.ordermgr.vo.OrderQueryModel;

public interface IOrderService extends IBaseService<OrderModel,OrderQueryModel> {
	public void order(int customerUuid);
}

