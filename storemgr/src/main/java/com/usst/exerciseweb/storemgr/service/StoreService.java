package com.usst.exerciseweb.storemgr.service;


import com.usst.exerciseweb.common.service.impl.IBaseServiceImpl;
import com.usst.exerciseweb.storemgr.dao.StoreDAO;
import com.usst.exerciseweb.storemgr.vo.StoreModel;
import com.usst.exerciseweb.storemgr.vo.StoreQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class StoreService extends IBaseServiceImpl<StoreModel,StoreQueryModel> implements IStoreService{
	private StoreDAO dao = null;
	@Autowired
	private void setDao(StoreDAO dao){
		this.dao = dao;
		super.setDAO(dao);
	}

	public StoreModel getByGoodsUuid(int goodsUuid) {
		return dao.getByGoodsUuid(goodsUuid);
	}
	
}