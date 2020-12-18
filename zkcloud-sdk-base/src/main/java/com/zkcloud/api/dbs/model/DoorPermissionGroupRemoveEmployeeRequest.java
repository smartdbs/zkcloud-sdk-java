package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorPermissionGroupRemoveEmployeeRequest extends AbstractModel {

    /**
     * 门禁权限组编号,企业内唯一
     */
    @Expose
    private Integer groupNum;

    /**
     * 员工工号列表
     */
    @Expose
    private List<String> employeeNos;


    public DoorPermissionGroupRemoveEmployeeRequest(Integer groupNum, List<String> employeeNos) {
        this.groupNum = groupNum;
        this.employeeNos = employeeNos;
    }

    public Integer getGroupNum() {
        return groupNum;
    }

    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
    }

    public List<String> getEmployeeNos() {
        return employeeNos;
    }

    public void setEmployeeNos(List<String> employeeNos) {
        this.employeeNos = employeeNos;
    }
}
