package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorPermissionGroupRemoveDoorRequest extends AbstractModel {


    @Expose
    private Integer groupNum;

    @Expose
    private String sn;

    @Expose
    private List<Integer> doorNums;


    public DoorPermissionGroupRemoveDoorRequest(Integer groupNum, String sn, List<Integer> doorNums) {
        this.groupNum = groupNum;
        this.sn = sn;
        this.doorNums = doorNums;
    }

    public DoorPermissionGroupRemoveDoorRequest(Integer groupNum, String sn) {
        this.groupNum = groupNum;
        this.sn = sn;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
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
