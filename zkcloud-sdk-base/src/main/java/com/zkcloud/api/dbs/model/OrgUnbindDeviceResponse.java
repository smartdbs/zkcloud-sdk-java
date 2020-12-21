package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class OrgUnbindDeviceResponse {

    /**
 　　* 解绑异常的设备序列号，异常情况才返回
 　　*/
    @Expose
    private String sn;

    /**
 　　* 解绑异常的组织架构编码，异常情况才返回
 　　*/
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
