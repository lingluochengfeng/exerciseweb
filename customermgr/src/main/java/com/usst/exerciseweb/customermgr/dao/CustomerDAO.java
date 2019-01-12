package com.usst.exerciseweb.customermgr.dao;

import com.usst.exerciseweb.common.dao.BaseDAO;
import com.usst.exerciseweb.customermgr.vo.CustomerModel;
import com.usst.exerciseweb.customermgr.vo.CustomerQueryModel;
import org.springframework.stereotype.Repository;


/**
 * @author ASUS
 * @since 2018-12-15 19:53
 */
@Repository
public interface CustomerDAO
        extends BaseDAO<CustomerModel,CustomerQueryModel> {

    public CustomerModel getByCustomerId(String customerId);

}
