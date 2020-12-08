package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class CreateCompanyResponse {
    @Expose
    private String companyId;
    @Expose
    private User apiUser;
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
