package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class CreateCompanyResponse {
    /**
　　  *  公司id
　　  */
    @Expose
    private String companyId;

    /**
　　  *  公司集成账户，接口调用时企业租户安全保障
　　  */
    @Expose
    private User apiUser;
    /**
      *  超级用户，用于企业管理员登陆smart-dbs Web系统
      */
    @Expose
    private User superUser;

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public User getApiUser() {
        return apiUser;
    }

    public void setApiUser(User apiUser) {
        this.apiUser = apiUser;
    }

    public User getSuperUser() {
        return superUser;
    }

    public void setSuperUser(User superUser) {
        this.superUser = superUser;
    }
}
