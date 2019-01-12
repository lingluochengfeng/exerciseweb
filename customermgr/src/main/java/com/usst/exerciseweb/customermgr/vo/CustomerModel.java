package com.usst.exerciseweb.customermgr.vo;

import com.usst.exerciseweb.common.vo.BaseModel;

/**
 * @author ASUS
 * @since 2018-12-15 19:46
 */
public class CustomerModel extends BaseModel {
    private String customerId;
    private String pwd;
    //这里的时间为了简单方便，采用String的形式，以后还是要多考虑
    private String registerTime;
    private String showName;
    private String trueName;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showTime) {
        this.showName = showTime;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "uuid=" + getUuid() +
                ", customerId='" + customerId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", showTime='" + showName + '\'' +
                ", trueName='" + trueName + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
