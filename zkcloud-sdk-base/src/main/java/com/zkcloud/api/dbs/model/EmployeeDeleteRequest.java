package com.zkcloud.api.dbs.model;


import cn.hutool.core.date.DateUtil;
import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class EmployeeDeleteRequest extends AbstractModel {

    /**
 　　*  员工编号
 　　*/
    @Expose
    private String employeeNo;

    /**
 　　*  第三方最后修改时间戳，若该时间戳小于或等于上一次该员工收到的时间戳，则该数据不处理，但会返回成功编码
 　　*/
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

