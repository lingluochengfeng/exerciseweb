package com.usst.exerciseweb.customermgr.dao;

import com.usst.exerciseweb.common.dao.BaseDAO;
import com.usst.exerciseweb.customermgr.vo.CustomerModel;
import com.usst.exerciseweb.customermgr.vo.CustomerQueryModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ASUS
 * @since 2018-12-15 19:53
 */
@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel,CustomerQueryModel> {

    public void create(CustomerModel cm);
    public void update(CustomerModel customerModel);
    public void delete(int uuid);


    public CustomerModel getByUuid(int uuid);
    public List<CustomerModel> getByConditionPage(CustomerQueryModel customerQueryModel);
}
