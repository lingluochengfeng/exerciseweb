package com.usst.exerciseweb.customermgr.service;

import com.usst.exerciseweb.common.service.IBaseService;
import com.usst.exerciseweb.customermgr.vo.CustomerModel;
import com.usst.exerciseweb.customermgr.vo.CustomerQueryModel;


public interface ICustomerService extends IBaseService<CustomerModel,CustomerQueryModel> {

    public CustomerModel getByCustomerId(String customerId);

}
