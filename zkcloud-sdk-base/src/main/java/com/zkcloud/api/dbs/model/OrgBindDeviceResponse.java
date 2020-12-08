package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class OrgBindDeviceResponse {
    @Expose
    private String sn;
    @Expose
    private String orgCode;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}
