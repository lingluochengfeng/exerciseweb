package com.usst.exerciseweb.common.web;

public class BaseWebModel {

    //需要查询的条件
    private String queryJsonStr = "";

    //当前的页面号
    private int nowPage = 1;

    //每页显示几条，默认为0
    private int pageShow = 0;

    public String getQueryJsonStr() {
        return queryJsonStr;
    }

    public void setQueryJsonStr(String queryJsonStr) {
        this.queryJsonStr = queryJsonStr;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getPageShow() {
        return pageShow;
    }

    public void setPageShow(int pageShow) {
        this.pageShow = pageShow;
    }

    @Override
    public String toString() {
        return "CustomerWebModel{" +
                "queryJsonStr='" + queryJsonStr + '\'' +
                ", nowPage=" + nowPage +
                ", pageShow=" + pageShow +
                '}';
    }
}
