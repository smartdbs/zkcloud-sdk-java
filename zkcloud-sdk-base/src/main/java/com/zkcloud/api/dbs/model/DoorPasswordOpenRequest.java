package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorPasswordOpenRequest extends AbstractModel {
    @Expose
    private String sn;

    @Expose
    private Integer doorNum;

    @Expose
    private String employeeNo;

    @Expose
    private String password;

    public DoorPasswordOpenRequest(String sn, String employeeNo, String password) {
        this.sn = sn;
        this.employeeNo = employeeNo;
        this.password = password;
    }

    public DoorPasswordOpenRequest(String sn, Integer doorNum, String employeeNo, String password) {
        this.sn = sn;
        this.doorNum = doorNum;
        this.employeeNo = employeeNo;
        this.password = password;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(Integer doorNum) {
        this.doorNum = doorNum;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
