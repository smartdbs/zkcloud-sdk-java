package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorParamQueryResponse extends AbstractModel {
    @Expose
    private String sn;

    @Expose
    private Integer doorNum;

    @Expose
    private List<DoorParam> doorParams;


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

    public List<DoorParam> getDoorParams() {
        return doorParams;
    }

    public void setDoorParams(List<DoorParam> doorParams) {
        this.doorParams = doorParams;
    }
}
