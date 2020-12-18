package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;
import java.util.List;

public class EmployeeUnbindDeviceRequest extends AbstractModel {

    /**
     * 设备序列号数组　　
     */
    @Expose
    private List<String> sns;

    /**
     * 员工工号数组，数组长度不超过100　　
     */
    @Expose
    private List<String> employeeNos;

    public EmployeeUnbindDeviceRequest(List<String> sns, List<String> employeeNos) {
        this.sns = sns;
        this.employeeNos = employeeNos;
    }

    public List<String> getSns() {
        return sns;
    }

    public void setSns(List<String> sns) {
        this.sns = sns;
    }

    public List<String> getEmployeeNos() {
        return employeeNos;
    }

    public void setEmployeeNos(List<String> employeeNos) {
        this.employeeNos = employeeNos;
    }
}
