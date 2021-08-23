package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorTransactionRecordResponse {

    /**
     * 打卡设备序列号
     */
    @Expose
    private  String sn;

    /**
     * 门编号
     */
    @Expose
    private  Integer doorNum;

    /**
     * 操作者，当验证通过时应为员工工号或访客编号，若远程开门时为远程开门时下发的操作者名称
     */
    @Expose
    private  String operator;

    /**
     * 门禁事件时间(iso8601标准格式)
     */
    @Expose
    private  String time;

    /**
     * 门禁事件时间(时间戳)
     */
    @Expose
    private  Long timeStamp;

    /**
     * 记录推送到服务器的时间
     */
    @Expose
    private  Long pushTime;

    /**
     * 出入状态，0:入，1:出
     */
    @Expose
    private  Integer inOutState;

    /**
     * 事件码，详见门禁实时事件码说明
     */
    @Expose
    private  String eventCode;

    /**
     * 验证方式，详见验证方式说明
     */
    @Expose
    private  Integer verified;


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public Integer getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(Integer doorNum) {
        this.doorNum = doorNum;
    }

    public Integer getInOutState() {
        return inOutState;
    }

    public void setInOutState(Integer inOutState) {
        this.inOutState = inOutState;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
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
