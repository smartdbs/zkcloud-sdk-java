package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorPasswordOpenRequest extends AbstractModel {
    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 门编号，取值范围，0～4。当门编号为0，则下发到该设备的所有门；当门编号为空或不传，则默认下发到编号为1的门
     */
    @Expose
    private Integer doorNum;

    /**
     * 操作者员工编号
     */
    @Expose
    private String employeeNo;

    /**
     * 开门密码，为下发固定密码中的密码的原始明文密码
     */
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
