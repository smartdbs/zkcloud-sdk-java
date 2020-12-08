package com.zkcloud.api.dbs.model;


import cn.hutool.core.date.DateUtil;
import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class EmployeeDeleteRequest extends AbstractModel {

    @Expose
    private String employeeNo;

    @Expose
    private Long lastUpdateTimeStamp;

    public EmployeeDeleteRequest(String employeeNo) {
        this(employeeNo, DateUtil.currentSeconds());
    }

    public EmployeeDeleteRequest(String employeeNo, Long lastUpdateTimeStamp) {
        this.employeeNo = employeeNo;
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Long getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(Long lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }
}

