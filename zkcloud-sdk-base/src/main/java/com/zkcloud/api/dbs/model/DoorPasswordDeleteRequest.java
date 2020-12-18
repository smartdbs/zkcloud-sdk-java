package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorPasswordDeleteRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 门编号，取值范围，0～4。当门编号为0，则删除该设备的所有门上的密码；当门编号为空或不传，则默认删除编号为1的门的密码
     */
    @Expose
    private Integer doorNum;

    /**
     * 密码下发的操作者员工编号，当该参数为空则删除所有操作者下发的密码
     */
    @Expose
    private String employeeNo;

    /**
     * password类型，0：固定密码；1：临时密码；当该参数为空则删除所有类型的密码
     */
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
