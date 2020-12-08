package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;
import java.util.List;

public class EmployeeDeleteBatchRequest extends AbstractModel {
    @Expose
    private List<EmployeeDeleteRequest> employees;

    public EmployeeDeleteBatchRequest(List<EmployeeDeleteRequest> employees) {
        this.employees = employees;
    }

    public List<EmployeeDeleteRequest> getEmployeeDeleteRequests() {
        return employees;
    }

    public void setEmployeeDeleteRequests(List<EmployeeDeleteRequest> employees) {
        this.employees = employees;
    }
}
