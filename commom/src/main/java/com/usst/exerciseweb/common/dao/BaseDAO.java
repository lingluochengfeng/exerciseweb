package com.usst.exerciseweb.common.dao;

import com.usst.exerciseweb.common.vo.BaseModel;

import java.util.List;

public interface BaseDAO<M,QM extends BaseModel> {

    public void create(M cm);
    public void update(M customerModel);
    public void delete(int uuid);


    public M getByUuid(int uuid);
    public List<M> getByConditionPage(QM customerQueryModel);
}
