package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class EmployeeUnbindDeviceResponse {

    /**
 　　* 解绑异常的设备序列号，异常情况才返回
 　　*/
    @Expose
    private String sn;

    /**
 　　* 解绑异常的员工工号，异常情况才返回
 　　*/
    @Expose
    private String employeeNo;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }
}
