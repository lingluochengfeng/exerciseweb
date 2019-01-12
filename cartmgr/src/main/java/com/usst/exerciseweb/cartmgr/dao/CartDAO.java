package com.usst.exerciseweb.cartmgr.dao;

import com.usst.exerciseweb.cartmgr.vo.CartModel;
import com.usst.exerciseweb.cartmgr.vo.CartQueryModel;
import com.usst.exerciseweb.common.dao.BaseDAO;
import org.springframework.stereotype.Repository;


@Repository
public interface CartDAO extends BaseDAO<CartModel,CartQueryModel> {
	
}
