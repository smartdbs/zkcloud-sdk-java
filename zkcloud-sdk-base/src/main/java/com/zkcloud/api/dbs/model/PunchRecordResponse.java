package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

public class PunchRecordResponse {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 员工工号
     */
    @Expose
    private String employeeNo;

    /**
     * 打卡时间戳
     */
    @Expose
    private Long punchTime;

    /**
     * 打卡时间(iso8601标准格式)
     */
    @Expose
    private String iso8601PunchTime;

    /**
     * 工作代码
     */
    @Expose
    private String workCode;

    /**
     * 打卡状态，0 上班签到，1 下班签退，2 外出，3 外出返回，4 加班签到，5 加班签退，255 默认
     */
    @Expose
    private String status;

    /**
     * 记录推送到服务器的时间
     */
    @Expose
    private Long pushTime;

    /**
     * 体温。此属性配合设备使用，当设备带体温检测功能才有返回值
     */
    @Expose
    private String temperature;

    /**
     * 是否佩戴口罩，0 未佩戴口罩，1 已佩戴口罩。此属性配合设备使用，当设备带口罩检测功能才有返回值
     */
    @Expose
    private String maskStatus;


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

    public Long getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(Long punchTime) {
        this.punchTime = punchTime;
    }

    public String getIso8601PunchTime() {
        return iso8601PunchTime;
    }

    public void setIso8601PunchTime(String iso8601PunchTime) {
        this.iso8601PunchTime = iso8601PunchTime;
    }

    public String getWorkCode() {
        return workCode;
    }

    public void setWorkCode(String workCode) {
        this.workCode = workCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getPushTime() {
        return pushTime;
    }

    public void setPushTime(Long pushTime) {
        this.pushTime = pushTime;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getMaskStatus() {
        return maskStatus;
    }

    public void setMaskStatus(String maskStatus) {
        this.maskStatus = maskStatus;
    }
}
