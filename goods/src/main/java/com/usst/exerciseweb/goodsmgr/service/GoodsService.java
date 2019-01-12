package com.usst.exerciseweb.goodsmgr.service;


import com.usst.exerciseweb.common.service.impl.IBaseServiceImpl;
import com.usst.exerciseweb.goodsmgr.dao.GoodsDAO;
import com.usst.exerciseweb.goodsmgr.vo.GoodsModel;
import com.usst.exerciseweb.goodsmgr.vo.GoodsQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class GoodsService extends IBaseServiceImpl<GoodsModel,GoodsQueryModel> implements IGoodsService{
	private GoodsDAO dao = null;
	@Autowired
	private void setDao(GoodsDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}
//	@Override
//	public Page<GoodsModel> getByConditionPage(GoodsQueryModel qm){
//		return dao.getByConditionPage(qm);
//	}
}