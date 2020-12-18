package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorHolidayUpdateRequest extends AbstractModel {

    /**
     * 节假日编号，企业内唯一
     */
    @Expose
    private String holidayCode;

    /**
     * 开始日期
     */
    @Expose
    private String startDate;

    /**
     * 截止日期，为空时等于startDate，即表示更新startDate当天节假日信息
     */
    @Expose
    private String endDate;

    /**
     * 节假日类型，取值7～9，对应更新门禁时间段中的week
     */
    @Expose
    private String type;

    /**
     * 节假日循环标志，1:年循环且月日相等, 2:必须年月日相等
     */
    @Expose
    private String loop;

    public String getHolidayCode() {
        return holidayCode;
    }

    public void setHolidayCode(String holidayCode) {
        this.holidayCode = holidayCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public DoorHolidayUpdateRequest(String holidayCode, String startDate, String endDate, String type, String loop) {
        this.holidayCode = holidayCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.loop = loop;
    }

    public DoorHolidayUpdateRequest(String holidayCode, String startDate, String type, String loop) {
        this.holidayCode = holidayCode;
        this.startDate = startDate;
        this.type = type;
        this.loop = loop;
    }
}
