package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

/**
 * 查询员工人脸照片 请求参数
 */
public class EmployeeFaceRequest extends AbstractModel {

    /**
 　　* 员工编号
 　　*/
    @Expose
    private String employeeNo;

    public EmployeeFaceRequest(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }
}
