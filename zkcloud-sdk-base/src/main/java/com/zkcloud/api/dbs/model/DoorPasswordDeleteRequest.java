package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorPasswordDeleteRequest extends AbstractModel {
    @Expose
    private String sn;

    @Expose
    private Integer doorNum;

    @Expose
    private String employeeNo;

    @Expose
    private String passwordType;

    public DoorPasswordDeleteRequest(String sn) {
        this.sn = sn;
    }

    public DoorPasswordDeleteRequest(String sn, Integer doorNum, String employeeNo, String passwordType) {
        this.sn = sn;
        this.doorNum = doorNum;
        this.employeeNo = employeeNo;
        this.passwordType = passwordType;
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

    public String getPasswordType() {
        return passwordType;
    }

    public void setPasswordType(String passwordType) {
        this.passwordType = passwordType;
    }
}
