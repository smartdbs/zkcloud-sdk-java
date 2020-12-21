package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorTimeZoneDetail extends AbstractModel {


    /**
     * 时间段类型，0～6表示周日～周六，7～9表示节假日类型，即7=节假日类型一，8=节假日类型二，9=节假日类型三
     */
    @Expose
    private Integer week;

    /**
     * 开始时间，格式HH:mm
     */
    @Expose
    private String startTime;

    /**
     * 截止时间，格式HH:mm
     */
    @Expose
    private String endTime;

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public DoorTimeZoneDetail(Integer week, String startTime, String endTime) {
        this.week = week;
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
