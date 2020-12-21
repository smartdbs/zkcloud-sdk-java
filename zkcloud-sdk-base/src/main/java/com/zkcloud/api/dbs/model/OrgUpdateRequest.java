package com.zkcloud.api.dbs.model;


import cn.hutool.core.date.DateUtil;
import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class OrgUpdateRequest extends AbstractModel {
    /**
     * 组织架构编码，企业内唯一
     */
    @Expose
    private String orgCode;

    /**
     * 组织架构名称
     */
    @Expose
    private String orgName;

    /**
     * 父级组织架构编码，若存在父级组织架构编码，则此处必填；若不存在父级组织架构编码，则默认父级组织架构为根组织架构。
     */
    @Expose
    private String parentOrgCode;

    /**
     * 第三方最后修改时间戳，若该时间戳小于或等于上一次该组织架构接收到的时间戳，则该数据不处理，但会返回成功编码
     */
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
