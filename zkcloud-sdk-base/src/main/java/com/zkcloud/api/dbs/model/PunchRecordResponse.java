package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

public class PunchRecordResponse {

    @Expose
    private String sn;
    @Expose
    private String employeeNo;
    @Expose
    private Long punchTime;
    @Expose
    private String iso8601PunchTime;
    @Expose
    private String workCode;
    @Expose
    private String status;
    @Expose
    private Long pushTime;

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
}
