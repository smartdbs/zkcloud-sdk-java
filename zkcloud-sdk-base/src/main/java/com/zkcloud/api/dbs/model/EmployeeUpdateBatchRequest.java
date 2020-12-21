package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class EmployeeUpdateBatchRequest extends AbstractModel {

    /**
 　　* 员工集合
 　　*/
    @SerializedName("employees")
    @Expose
    private List<EmployeeUpdateRequest> employeeList;

    public EmployeeUpdateBatchRequest() {
    }

    public EmployeeUpdateBatchRequest(List<EmployeeUpdateRequest> employeeList) {
        this.employeeList = employeeList;
    }

    public List<EmployeeUpdateRequest> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<EmployeeUpdateRequest> employeeList) {
        this.employeeList = employeeList;
    }
}
