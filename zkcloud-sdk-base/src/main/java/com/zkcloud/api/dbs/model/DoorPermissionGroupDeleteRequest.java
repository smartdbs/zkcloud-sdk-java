package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorPermissionGroupDeleteRequest extends AbstractModel {


    @Expose
    private Integer groupNum;

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public DoorPermissionGroupDeleteRequest(Integer groupNum) {
        this.groupNum = groupNum;
    }
}
