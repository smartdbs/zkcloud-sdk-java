package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorPermissionGroupAddDoorDevice extends AbstractModel {


    @Expose
    private String sn;

    @Expose
    private List<Integer> doorNums;


    public DoorPermissionGroupAddDoorDevice(String sn, List<Integer> doorNums) {
        this.sn = sn;
        this.doorNums = doorNums;
    }


    public DoorPermissionGroupAddDoorDevice(String sn) {
        this.sn = sn;
    }


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<Integer> getDoorNums() {
        return doorNums;
    }

    public void setDoorNums(List<Integer> doorNums) {
        this.doorNums = doorNums;
    }
}
