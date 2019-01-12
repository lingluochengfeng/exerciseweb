package com.usst.exerciseweb.storemgr.dao;

import com.usst.exerciseweb.common.dao.BaseDAO;
import com.usst.exerciseweb.storemgr.vo.StoreModel;
import com.usst.exerciseweb.storemgr.vo.StoreQueryModel;
import org.springframework.stereotype.Repository;


@Repository
public interface StoreDAO extends BaseDAO<StoreModel,StoreQueryModel> {
	public StoreModel getByGoodsUuid(int goodsUuid);
}
