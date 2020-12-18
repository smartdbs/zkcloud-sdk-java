package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorPermissionGroupDeleteRequest extends AbstractModel {

    /**
     * 门禁权限组编号,企业内唯一
     */
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
