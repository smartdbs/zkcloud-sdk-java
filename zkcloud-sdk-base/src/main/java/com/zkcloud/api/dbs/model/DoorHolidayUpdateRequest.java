package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorHolidayUpdateRequest extends AbstractModel {


    @Expose
    private String holidayCode;

    @Expose
    private String startDate;

    @Expose
    private String endDate;

    @Expose
    private String type;

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
