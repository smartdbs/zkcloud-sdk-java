package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorUpdateRequest extends AbstractModel {
    @Expose
    private String sn;
    @Expose
    private Integer doorNum;
    @Expose
    private String doorName;
    @Expose
    private Integer enable;
    @Expose
    private Integer address;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(Integer doorNum) {
        this.doorNum = doorNum;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public DoorUpdateRequest(String sn, Integer doorNum, String doorName) {
        this.sn = sn;
        this.doorNum = doorNum;
        this.doorName = doorName;
    }
}
