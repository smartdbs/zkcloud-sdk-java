package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class EmployeeGroupDeleteRequest extends AbstractModel {

    /**
     * 人员组编号，企业内唯一
     */
    @Expose
    private Integer group;

    public EmployeeGroupDeleteRequest(Integer group) {
        this.group = group;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

}
