package com.usst.exerciseweb.customermgr.vo;

import com.usst.pageutil.Page;

/**
 * 封装查询条件
 * @author ASUS
 * @since 2018-12-15 19:51
 */
public class CustomerQueryModel extends CustomerModel {

    private Page<CustomerModel> page = new Page<>();

    public Page<CustomerModel> getPage() {
        return page;
    }

    public void setPage(Page<CustomerModel> page) {
        this.page = page;
    }
}
