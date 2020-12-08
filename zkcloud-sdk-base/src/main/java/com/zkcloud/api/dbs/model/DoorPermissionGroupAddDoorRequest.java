package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorPermissionGroupAddDoorRequest extends AbstractModel {


    @Expose
    private Integer groupNum;

    @Expose
    private List<DoorPermissionGroupAddDoorDevice> devices;


    public DoorPermissionGroupAddDoorRequest(Integer groupNum, List<DoorPermissionGroupAddDoorDevice> devices) {
        this.groupNum = groupNum;
        this.devices = devices;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public List<DoorPermissionGroupAddDoorDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<DoorPermissionGroupAddDoorDevice> devices) {
        this.devices = devices;
    }
}
