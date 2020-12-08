package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorTimeZoneUpdateRequest extends AbstractModel {



    @Expose
    private Integer timezoneNum;

    @Expose
    private String timezoneName;

    /**
     * 注: 因为 default 为java关键字，不可声明，故使用 isDefault代替,使用@SerializedName，序列化时 将isDefault序列化成 default
     */
    @SerializedName(value = "default")
    @Expose(serialize = true,deserialize = true)
    private Integer isDefault;

    @Expose
    private List<DoorTimeZoneDetail> detail;

    public Integer getTimezoneNum() {
        return timezoneNum;
    }

    public void setTimezoneNum(Integer timezoneNum) {
        this.timezoneNum = timezoneNum;
    }

    public String getTimezoneName() {
        return timezoneName;
    }

    public void setTimezoneName(String timezoneName) {
        this.timezoneName = timezoneName;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public List<DoorTimeZoneDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<DoorTimeZoneDetail> detail) {
        this.detail = detail;
    }

    public DoorTimeZoneUpdateRequest(Integer timezoneNum, String timezoneName, Integer isDefault, List<DoorTimeZoneDetail> detail) {
        this.timezoneNum = timezoneNum;
        this.timezoneName = timezoneName;
        this.isDefault = isDefault;
        this.detail = detail;
    }

    public DoorTimeZoneUpdateRequest(Integer timezoneNum, String timezoneName, Integer isDefault) {
        this.timezoneNum = timezoneNum;
        this.timezoneName = timezoneName;
        this.isDefault = isDefault;
    }
}
