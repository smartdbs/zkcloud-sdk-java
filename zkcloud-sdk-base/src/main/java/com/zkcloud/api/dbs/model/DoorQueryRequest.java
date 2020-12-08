package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorQueryRequest extends AbstractModel {
    @Expose
    private String sn;
    @Expose
    private Integer doorNum;

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

    public DoorQueryRequest(String sn, Integer doorNum ) {
        this.sn = sn;
        this.doorNum = doorNum;
    }

    public DoorQueryRequest(String sn ) {
        this.sn = sn;
        this.doorNum =null ;
    }
}
