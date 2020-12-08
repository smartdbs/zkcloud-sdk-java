package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class EmployeeDeleteResponse {
    @Expose
    private String employeeNo;
    @Expose
    private String code;
    @Expose
    private String message;

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
