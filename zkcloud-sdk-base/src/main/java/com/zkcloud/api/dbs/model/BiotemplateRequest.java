package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class BiotemplateRequest extends AbstractModel {

    @Expose
    private String employeeNo;

    @Expose
    private String type;

    public BiotemplateRequest(String employeeNo, String type) {
        this.employeeNo = employeeNo;
        this.type = type;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

