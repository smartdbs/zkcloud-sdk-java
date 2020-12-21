package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class PunchRecordRequest extends AbstractModel {

    /**
     * 打卡开始Unix时间戳，精确到秒（默认查询条件）
     */
    @Expose
    private Long startTime;

    /**
     * 打卡截止Unix时间戳，精确到秒，为空时默认当前时间（默认查询条件）
     */
    @Expose
    private Long endTime;

    /**
     * 开始Unix时间戳，精确到秒，此处指设备将记录推送到服务端的时间
     */
    @Expose
    private Long pushStartTime;

    /**
     * 截止Unix时间戳，精确到秒，此处指设备将记录推送到服务端的时间，为空时默认当前时间
     */
    @Expose
    private Long pushEndTime;

    public PunchRecordRequest(){

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

    public Long getPushStartTime() {
        return pushStartTime;
    }

    public void setPushStartTime(Long pushStartTime) {
        this.pushStartTime = pushStartTime;
    }

    public Long getPushEndTime() {
        return pushEndTime;
    }

    public void setPushEndTime(Long pushEndTime) {
        this.pushEndTime = pushEndTime;
    }

    public PunchRecordRequest(Long pushStartTime, Long pushEndTime){
        this(null,null,pushStartTime, pushEndTime);
    }

    public PunchRecordRequest(Long startTime, Long endTime, Long pushStartTime, Long pushEndTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.pushStartTime = pushStartTime;
        this.pushEndTime = pushEndTime;
    }
}
