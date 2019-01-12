package com.usst.exerciseweb.storemgr.service;


import com.usst.exerciseweb.common.service.IBaseService;
import com.usst.exerciseweb.storemgr.vo.StoreModel;
import com.usst.exerciseweb.storemgr.vo.StoreQueryModel;

public interface IStoreService extends IBaseService<StoreModel,StoreQueryModel> {
	public StoreModel getByGoodsUuid(int goodsUuid);
}

