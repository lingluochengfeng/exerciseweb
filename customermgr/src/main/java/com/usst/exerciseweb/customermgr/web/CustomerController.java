package com.usst.exerciseweb.customermgr.web;

import com.usst.exerciseweb.customermgr.service.ICustomerService;
import com.usst.exerciseweb.customermgr.vo.CustomerModel;
import com.usst.exerciseweb.customermgr.vo.CustomerQueryModel;
import com.usst.pageutil.Page;
import com.usst.util.format.DateFormatHelper;
import com.usst.util.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    /**
     * @Resource和@Qualifier+@Autowired的效果都能实现
     * 注意@Qualifier的类是service的实现类
     */
    @Qualifier("ICustomerServiceImpl")
    @Autowired
    private ICustomerService iCustomerService;

    @RequestMapping(value = "toAdd",method = RequestMethod.GET)
    private String toAdd(){
        return "customer/add";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    private String add(@ModelAttribute("cm") CustomerModel customerModel){
        customerModel.setRegisterTime(DateFormatHelper.long2str(System.currentTimeMillis()));
        iCustomerService.create(customerModel);
        return "customer/success";
    }

    @RequestMapping(value = "toUpdate/{customerUuid}",method = RequestMethod.GET)
    private String toUpdate(Model model,
                            @PathVariable("customerUuid") int customerUuid){
        CustomerModel cm = iCustomerService.getByUuid(customerUuid);
        model.addAttribute("cm", cm);
        return "customer/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    private String update(@ModelAttribute("cm") CustomerModel customerModel){
        iCustomerService.update(customerModel);
        return "customer/success";
    }

    @RequestMapping(value = "toDelete/{customerUuid}", method = RequestMethod.GET)
    private String toDelete(Model model,
                            @PathVariable("customerUuid") int customerUuid){
        CustomerModel customerModel = iCustomerService.getByUuid(customerUuid);
        model.addAttribute("cm", customerModel);
        return "customer/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    private String post(@RequestParam("uuid") int customerUuid){
        iCustomerService.delete(customerUuid);
        return "customer/success";
    }


    /**
     * 用于展示列表的结果
     * @param model
     * @return
     */
    @RequestMapping(value = "toList", method = RequestMethod.GET)
    private String toList(@ModelAttribute("wm") CustomerWebModel wm, Model model){

        CustomerQueryModel cqm = null;
        if (wm.getQueryJsonStr() == null || wm.getQueryJsonStr().trim().length() == 0){
            cqm = new CustomerQueryModel();
        }else {
//            cqm = (CustomerQueryModel) JsonHelper.str2Object("queryJsonStr", CustomerQueryModel.class);
            cqm = (CustomerQueryModel) JsonHelper.str2Object(wm.getQueryJsonStr(), CustomerQueryModel.class);
        }

        //从第几页开始显示
        cqm.getPage().setNowPage(wm.getNowPage());

        //如果显示的的条数大于0的话，显示几条
        if (wm.getPageShow() > 0){
            cqm.getPage().setPageShow(wm.getPageShow());
        }

        Page dbPage = iCustomerService.getByConditionPage(cqm);

        model.addAttribute("wm", wm);
        model.addAttribute("page", dbPage);

        return "customer/list";
    }

    @RequestMapping(value = "toQuery", method = RequestMethod.GET)
    private String toQuery(){

        return "customer/query";
    }

}