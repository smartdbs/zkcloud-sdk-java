package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class EmployeeBindDeviceResponse {
    @Expose
    private String sn;
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
