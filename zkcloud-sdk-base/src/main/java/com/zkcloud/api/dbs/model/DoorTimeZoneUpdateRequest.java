package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorTimeZoneUpdateRequest extends AbstractModel {


    /**
     * 门禁时间段编号,企业内唯一;时间段编号1 为企业内初始的默认时间段编号，该时间段不允许删除，只允许更新
     */
    @Expose
    private Integer timezoneNum;

    /**
     * 门禁时间段名称
     */
    @Expose
    private String timezoneName;

    /**
     * 门禁时间段详情，当为空时，默认周一～周日都是24小时通行，detail内容属于覆盖模式，即每次入参都必须是当前timezoneNum下完整的时间段详情
     */
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

    public List<DoorTimeZoneDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<DoorTimeZoneDetail> detail) {
        this.detail = detail;
    }

    public DoorTimeZoneUpdateRequest(Integer timezoneNum, String timezoneName, List<DoorTimeZoneDetail> detail) {
        this.timezoneNum = timezoneNum;
        this.timezoneName = timezoneName;
        this.detail = detail;
    }

    public DoorTimeZoneUpdateRequest(Integer timezoneNum, String timezoneName) {
        this.timezoneNum = timezoneNum;
        this.timezoneName = timezoneName;
    }
}
