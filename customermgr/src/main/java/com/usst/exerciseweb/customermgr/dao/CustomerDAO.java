package com.usst.exerciseweb.customermgr.dao;

import com.usst.exerciseweb.customermgr.vo.CustomerModel;
import com.usst.exerciseweb.customermgr.vo.CustomerQueryModel;

import java.util.List;

/**
 * @author ASUS
 * @since 2018-12-15 19:53
 */
public interface CustomerDAO {

    public void create(CustomerModel customerModel);
    public void update(CustomerModel customerModel);
    public void delete(int uuid);


    public CustomerModel getByUuid(int uuid);
    public List<CustomerModel> getByCondition(CustomerQueryModel customerQueryModel);
}
