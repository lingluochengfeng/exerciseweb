package com.usst.exerciseweb.ordermgr.dao;

import com.usst.exerciseweb.common.dao.BaseDAO;
import com.usst.exerciseweb.ordermgr.vo.OrderModel;
import com.usst.exerciseweb.ordermgr.vo.OrderQueryModel;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDAO extends BaseDAO<OrderModel,OrderQueryModel> {
	
}
