package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class EmployeeUpdateResponse {

    /**
 　　* 员工编号
 　　*/
    @Expose
    private String employeeNo;

    /**
 　　* 返回值编码,当且仅当code=00000000时表示消息处理成功
 　　*/
    @Expose
    private String code;

    /**
 　　* 消息内容
 　　*/
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
