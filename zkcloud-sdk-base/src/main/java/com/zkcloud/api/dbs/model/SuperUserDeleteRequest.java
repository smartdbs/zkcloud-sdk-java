package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class SuperUserDeleteRequest extends AbstractModel {

    /**
     * 人员编号
     */
    @Expose
    private String employeeNo;

    public SuperUserDeleteRequest(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }
}
