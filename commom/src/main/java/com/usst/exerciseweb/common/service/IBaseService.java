package com.usst.exerciseweb.common.service;

import com.usst.exerciseweb.common.vo.BaseModel;
import com.usst.pageutil.Page;

import java.util.List;

public interface IBaseService<M,QM extends BaseModel> {
    public void create(M m);
    public void update(M m);
    public void delete(int uuid);

    public M getByUuid(int uuid);
    public Page<M> getByConditionPage(QM qm);
}
