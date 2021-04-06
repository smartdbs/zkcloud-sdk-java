package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorPermissionGroupRemoveAllEmployeeRequest extends AbstractModel {

    /**
     * 门禁权限组编号,企业内唯一
     */
    @Expose
    private Integer groupNum;

    public DoorPermissionGroupRemoveAllEmployeeRequest(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }
}
