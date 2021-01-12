package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorPasswordUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 门编号，取值范围，1～4。当门编号为空或不传，则默认下发到编号为1的门
     */
    @Expose
    private Integer doorNum;

    /**
     * 操作者员工编号
     */
    @Expose
    private String employeeNo;

    /**
     * 有效开始时间
     */
    @Expose
    private Long startTime;

    /**
     * 有效结束时间
     */
    @Expose
    private Long endTime;

    /**
     * 密码，算法：PBKDF2WithHmacSHA256，密文长度：32字节，迭代次数：1000
     */
    @Expose
    private String password;

    /**
     * password加密的盐值
     */
    @Expose
    private String passwordSalt;

    /**
     * password类型，0：固定密码（默认），一个操作者对一个门只能设置一个固定密码，startTime和endTime不用传；1：临时密码，一个操作者对一个门只能设置一个临时密码，startTime和endTime必传
     */
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
