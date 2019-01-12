package com.usst.exerciseweb.cartmgr.service;


import com.usst.exerciseweb.cartmgr.dao.CartDAO;
import com.usst.exerciseweb.cartmgr.vo.CartModel;
import com.usst.exerciseweb.cartmgr.vo.CartQueryModel;
import com.usst.exerciseweb.common.service.impl.IBaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class CartService extends IBaseServiceImpl<CartModel,CartQueryModel> implements ICartService{
	private CartDAO dao = null;
	@Autowired
	private void setDao(CartDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}
	
}