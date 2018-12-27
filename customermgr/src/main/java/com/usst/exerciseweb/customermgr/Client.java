package com.usst.exerciseweb.customermgr;

import com.usst.exerciseweb.customermgr.dao.CustomerDAO;
import com.usst.exerciseweb.customermgr.vo.CustomerModel;
import com.usst.exerciseweb.customermgr.vo.CustomerQueryModel;
import com.usst.pageutil.Page;
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
        cm.setCustomerId("c5");
        cm.setRegisterTime("2017");
        cm.setShowName("c5");
        cm.setTrueName("哈根达斯");

        //这是没分页的代码
//        t.customerDAO.create(cm);
//        List<CustomerModel> list = t.customerDAO.
//                getByCondition(new CustomerQueryModel());
//        System.out.println(list);

        //这是分页的代码
        CustomerQueryModel cqm = new CustomerQueryModel();
        cqm.getPage().setNowPage(1);
        cqm.getPage().setPageShow(3);
        //把mapper和接口的条件改为getByConditionPage
        List<CustomerModel> list = t.customerDAO.
                getByConditionPage(cqm);
        System.out.println(list);

        System.out.println("page==" + cqm.getPage());

    }

}
