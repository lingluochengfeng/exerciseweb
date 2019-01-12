package com.usst.exerciseweb.goodsmgr.dao;

import com.usst.exerciseweb.common.dao.BaseDAO;
import com.usst.exerciseweb.goodsmgr.vo.GoodsModel;
import com.usst.exerciseweb.goodsmgr.vo.GoodsQueryModel;
import org.springframework.stereotype.Repository;



@Repository
public interface GoodsDAO extends BaseDAO<GoodsModel,GoodsQueryModel> {
//	public Page<GoodsModel> getByCondition(GoodsQueryModel qm);
}
