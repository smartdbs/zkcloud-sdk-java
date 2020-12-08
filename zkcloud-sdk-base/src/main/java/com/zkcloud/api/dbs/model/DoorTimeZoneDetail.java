package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorTimeZoneDetail extends AbstractModel {



    @Expose
    private Integer week;

    @Expose
    private String startTime;

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
