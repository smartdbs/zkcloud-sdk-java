package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class OrgUpdateResponse {
    @Expose
    private String orgCode;
    @Expose
    private String code;
    @Expose
    private String message;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
