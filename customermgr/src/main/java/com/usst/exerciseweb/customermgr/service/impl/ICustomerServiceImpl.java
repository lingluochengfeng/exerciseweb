package com.usst.exerciseweb.customermgr.service.impl;

import com.usst.exerciseweb.common.service.impl.IBaseServiceImpl;
import com.usst.exerciseweb.customermgr.dao.CustomerDAO;
import com.usst.exerciseweb.customermgr.service.ICustomerService;
import com.usst.exerciseweb.customermgr.vo.CustomerModel;
import com.usst.exerciseweb.customermgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ICustomerServiceImpl
        extends IBaseServiceImpl<CustomerModel, CustomerQueryModel>
        implements ICustomerService {

    private CustomerDAO customerDAO = null;

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
        super.setDAO(customerDAO);
    }

    @Override
    public CustomerModel getByCustomerId(String customerId) {
        return customerDAO.getByCustomerId(customerId);

    }
}
