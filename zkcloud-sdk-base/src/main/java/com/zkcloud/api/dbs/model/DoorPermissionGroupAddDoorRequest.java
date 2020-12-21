package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorPermissionGroupAddDoorRequest extends AbstractModel {

    /**
     * 门禁权限组编号,企业内唯一
     */
    @Expose
    private Integer groupNum;

    /**
     * 设备信息列表
     */
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
