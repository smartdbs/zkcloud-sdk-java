package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorTransactionRecordResponse extends AbstractModel {

    @Expose
    private  String sn;

    @Expose
    private  String doorNum;

    @Expose
    private  String operator;

    @Expose
    private  String time;

    @Expose
    private  Long timeStamp;

    @Expose
    private  Long pushTime;

    @Expose
    private  String inOutState;

    @Expose
    private  String eventCode;

    @Expose
    private  String verified;


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(String doorNum) {
        this.doorNum = doorNum;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getPushTime() {
        return pushTime;
    }

    public void setPushTime(Long pushTime) {
        this.pushTime = pushTime;
    }

    public String getInOutState() {
        return inOutState;
    }

    public void setInOutState(String inOutState) {
        this.inOutState = inOutState;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "DoorTransactionRecordResponse{" +
                "sn='" + sn + '\'' +
                ", doorNum='" + doorNum + '\'' +
                ", operator='" + operator + '\'' +
                ", time='" + time + '\'' +
                ", timeStamp=" + timeStamp +
                ", pushTime=" + pushTime +
                ", inOutState='" + inOutState + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", verified='" + verified + '\'' +
                '}';
    }
}
