package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorPasswordUpdateRequest extends AbstractModel {
    @Expose
    private String sn;

    @Expose
    private Integer doorNum;

    @Expose
    private String employeeNo;

    @Expose
    private Long startTime;

    @Expose
    private Long endTime;

    @Expose
    private String password;

    @Expose
    private String passwordSalt;

    @Expose
    private String passwordType;

    public DoorPasswordUpdateRequest(String sn, String employeeNo, String password) {
        this.sn = sn;
        this.employeeNo = employeeNo;
        this.password = password;
    }

    public DoorPasswordUpdateRequest(String sn, Integer doorNum, String employeeNo, Long startTime, Long endTime, String password, String passwordSalt, String passwordType) {
        this.sn = sn;
        this.doorNum = doorNum;
        this.employeeNo = employeeNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.password = password;
        this.passwordSalt = passwordSalt;
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

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordType() {
        return passwordType;
    }

    public void setPasswordType(String passwordType) {
        this.passwordType = passwordType;
    }
}
