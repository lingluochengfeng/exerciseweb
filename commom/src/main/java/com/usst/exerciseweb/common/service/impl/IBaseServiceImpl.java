package com.usst.exerciseweb.common.service.impl;

import com.usst.exerciseweb.common.dao.BaseDAO;
import com.usst.exerciseweb.common.service.IBaseService;
import com.usst.exerciseweb.common.vo.BaseModel;
import com.usst.pageutil.Page;

import java.util.List;

public class IBaseServiceImpl<M,QM extends BaseModel> implements IBaseService<M,QM> {

    private BaseDAO dao = null;

    public void setDAO(BaseDAO dao){
        this.dao = dao;
    }

    @Override
    public void create(M m) {
        dao.create(m);
    }

    @Override
    public void update(M m) {
        dao.update(m);
    }

    @Override
    public void delete(int uuid) {
        dao.delete(uuid);
    }

    @Override
    public M getByUuid(int uuid) {
        return (M) dao.getByUuid(uuid);
    }

    @Override
    public Page<M> getByConditionPage(QM qm) {
        List<M> list = dao.getByConditionPage(qm);
        qm.getPage().setResult(list);

        return (Page<M>) qm.getPage();
    }
}
