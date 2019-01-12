package com.usst.exerciseweb.ordermgr.dao;

import com.usst.exerciseweb.common.dao.BaseDAO;
import com.usst.exerciseweb.ordermgr.vo.OrderDetailModel;
import com.usst.exerciseweb.ordermgr.vo.OrderDetailQueryModel;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailDAO extends BaseDAO<OrderDetailModel,OrderDetailQueryModel> {
	
}
