package com.usst.exerciseweb.customermgr;

import com.usst.exerciseweb.customermgr.dao.CustomerDAO;
import com.usst.exerciseweb.customermgr.vo.CustomerModel;
import com.usst.exerciseweb.customermgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ASUS
 * @since 2018-12-17 22:09
 */
@Service
public class Client {

    @Autowired
    private CustomerDAO customerDAO;

    public static void main(String[] args) {
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        Client t = (Client) ctx.getBean("client");

        CustomerModel cm = new CustomerModel();
        cm.setCustomerId("c2");
        cm.setRegisterTime("2018");
        cm.setShowName("c2");
        cm.setTrueName("里斯");

        t.customerDAO.create(cm);

        List<CustomerModel> list = t.customerDAO.
                getByCondition(new CustomerQueryModel());
        System.out.println(list);
        System.out.println("hahha");
    }

}
