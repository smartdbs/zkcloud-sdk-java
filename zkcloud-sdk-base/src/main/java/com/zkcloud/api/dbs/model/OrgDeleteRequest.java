package com.zkcloud.api.dbs.model;


import cn.hutool.core.date.DateUtil;
import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class OrgDeleteRequest extends AbstractModel {

    /**
　　  * 组织架构编码
　　  */
    @Expose
    private String orgCode;

    /**
　　  * 是否自动解绑该部门关联的员工，1:是，0:否（默认），若为否，则必须先解绑该组织架构关联的人员信息
　　  */
    @Expose
    private String autoUnbindEmployee;

    /**
　　  * 第三方最后修改时间戳，若该时间戳小于或等于上一次该组织架构接收到的时间戳，则该数据不处理，但会返回成功编码
　　  */
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
