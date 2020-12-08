package com.zkcloud.api.dbs.model;


import cn.hutool.core.date.DateUtil;
import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class OrgUpdateRequest extends AbstractModel {
    @Expose
    private String orgCode;

    @Expose
    private String orgName;

    @Expose
    private String parentOrgCode;

    @Expose
    private Long lastUpdateTimeStamp;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getParentOrgCode() {
        return parentOrgCode;
    }

    public void setParentOrgCode(String parentOrgCode) {
        this.parentOrgCode = parentOrgCode;
    }

    public Long getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(Long lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public OrgUpdateRequest() {
    }

    public OrgUpdateRequest(String orgCode, String orgName) {
        this(orgCode, orgName, null);
    }

    public OrgUpdateRequest(String orgCode, String orgName, String parentOrgCode) {
        this.orgCode = orgCode;
        this.orgName = orgName;
        this.parentOrgCode = parentOrgCode;
        this.lastUpdateTimeStamp = DateUtil.currentSeconds();
    }
}
