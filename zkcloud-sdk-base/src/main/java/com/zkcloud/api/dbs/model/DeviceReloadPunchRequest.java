package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DeviceReloadPunchRequest extends AbstractModel {
    /**
      * 设备序列号
      */
    @Expose
    private String sn;

    /**
      * 打卡开始Unix时间戳，精确到秒
      */
    @Expose
    private Long startTime;

    /**
     * 打卡截止Unix时间戳，精确到秒
     */
    @Expose
    private Long endTime;

    /**
     * 设备在线校验。0代表不校验设备状态，执行该操作，1代表设备在线才执行此操作(默认)
     */
    @Expose
    private String onlineCheck;

    public DeviceReloadPunchRequest(String sn, Long startTime, Long endTime) {
        this(sn, startTime,endTime, null);
    }

    public DeviceReloadPunchRequest(String sn, Long startTime, Long endTime, String onlineCheck) {
        this.sn = sn;
        this.startTime = startTime;
        this.endTime = endTime;
        this.onlineCheck = onlineCheck;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public String getOnlineCheck() {
        return onlineCheck;
    }

    public void setOnlineCheck(String onlineCheck) {
        this.onlineCheck = onlineCheck;
    }
}
