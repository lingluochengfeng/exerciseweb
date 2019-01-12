package com.usst.exerciseweb.customermgr;

import com.usst.exerciseweb.customermgr.dao.CustomerDAO;
import com.usst.exerciseweb.customermgr.service.ICustomerService;
import com.usst.exerciseweb.customermgr.vo.CustomerModel;
import com.usst.exerciseweb.customermgr.vo.CustomerQueryModel;
import com.usst.pageutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ASUS
 * @since 2018-12-17 22:09
 */
@Service
@Transactional
public class Client {

    //dao的测试方式
//    @Autowired
//    private CustomerDAO customerDAO;

    //service的测试方式
    @Qualifier("ICustomerServiceImpl")
    @Autowired
    private ICustomerService s = null;

    public ICustomerService getS(){
        return s;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        Client t = (Client) ctx.getBean("client");

        CustomerModel cm = new CustomerModel();
        cm.setCustomerId("c5");
        cm.setRegisterTime("2017");
        cm.setShowName("c5");
        cm.setTrueName("为什么404");

        //这是没分页的代码
//        t.customerDAO.create(cm);
//        List<CustomerModel> list = t.customerDAO.
//                getByCondition(new CustomerQueryModel());
//        System.out.println(list);

        //这是分页的代码
        CustomerQueryModel cqm = new CustomerQueryModel();
        cqm.getPage().setNowPage(1);
        cqm.getPage().setPageShow(2);
        //把mapper和接口的条件改为getByConditionPage
//        List<CustomerModel> list = t.customerDao.
//                getByConditionPage(cqm);
        //service的实现中的测试方式
//        Page<CustomerModel> list = t.getS().getByConditionPage(cqm);
//        System.out.println(list);

        //测试缓存是否成功，看日志，是否查询了两次数据库，如果查询了两次则缓存失败，否则成功
        Page<CustomerModel> list = t.getS().getByConditionPage(cqm);
        System.out.println(list);

        Page<CustomerModel> list1 = t.getS().getByConditionPage(cqm);
        System.out.println(list1);
        System.out.println("page==" + cqm.getPage());

    }

}
