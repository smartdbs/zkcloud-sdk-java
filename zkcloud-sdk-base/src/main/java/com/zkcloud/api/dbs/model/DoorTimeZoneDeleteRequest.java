package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorTimeZoneDeleteRequest extends AbstractModel {



    @Expose
    private Integer timezoneNum;


    public Integer getTimezoneNum() {
        return timezoneNum;
    }

    public void setTimezoneNum(Integer timezoneNum) {
        this.timezoneNum = timezoneNum;
    }


    public DoorTimeZoneDeleteRequest(Integer timezoneNum) {
        this.timezoneNum = timezoneNum;
    }
}
