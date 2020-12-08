package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorPermissionGroupUpdateRequest extends AbstractModel {


    @Expose
    private Integer groupNum;

    @Expose
    private Integer timezoneNum;

    @Expose
    private String startTime;

    @Expose
    private String endTime;


    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getTimezoneNum() {
        return timezoneNum;
    }

    public void setTimezoneNum(Integer timezoneNum) {
        this.timezoneNum = timezoneNum;
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


    public DoorPermissionGroupUpdateRequest(Integer groupNum, Integer timezoneNum) {
        this.groupNum = groupNum;
        this.timezoneNum = timezoneNum;
    }

    public DoorPermissionGroupUpdateRequest(Integer groupNum, Integer timezoneNum, String startTime, String endTime) {
        this.groupNum = groupNum;
        this.timezoneNum = timezoneNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
