package com.zkcloud.api.dbs.model;


import cn.hutool.core.date.DateUtil;
import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class OrgDeleteRequest extends AbstractModel {
    @Expose
    private String orgCode;

    @Expose
    private String autoUnbindEmployee;

    @Expose
    private Long lastUpdateTimeStamp;

    public OrgDeleteRequest() {
    }

    public OrgDeleteRequest(String orgCode) {
        this(orgCode, "0");
    }

    public OrgDeleteRequest(String orgCode, String autoUnbindEmployee) {
        this(orgCode, autoUnbindEmployee, DateUtil.currentSeconds());
    }

    public OrgDeleteRequest(String orgCode, String autoUnbindEmployee, Long lastUpdateTimeStamp) {
        this.orgCode = orgCode;
        this.autoUnbindEmployee = autoUnbindEmployee;
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getAutoUnbindEmployee() {
        return autoUnbindEmployee;
    }

    public void setAutoUnbindEmployee(String autoUnbindEmployee) {
        this.autoUnbindEmployee = autoUnbindEmployee;
    }

    public Long getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(Long lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }
}
