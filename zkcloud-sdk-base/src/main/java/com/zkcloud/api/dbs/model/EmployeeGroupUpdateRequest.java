package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class EmployeeGroupUpdateRequest extends AbstractModel {

    /**
     * 人员组编号，企业内唯一
     */
    @Expose
    private Integer group;

    /**
     * 人员组编号名称
     */
    @Expose
    private String groupName;

    /**
     * 人员列表，长度不少于2
     */
    @Expose
    private String[] employeeNos;

    public EmployeeGroupUpdateRequest(Integer group, String[] employeeNos) {
        this.group = group;
        this.employeeNos = employeeNos;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String[] getEmployeeNos() {
        return employeeNos;
    }

    public void setEmployeeNos(String[] employeeNos) {
        this.employeeNos = employeeNos;
    }
}
