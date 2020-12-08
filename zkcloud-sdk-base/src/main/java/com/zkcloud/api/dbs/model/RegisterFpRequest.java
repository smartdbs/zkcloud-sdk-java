package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class RegisterFpRequest extends AbstractModel {

    @Expose
    private String sn;
    @Expose
    private String employeeNo;
    @Expose
    private String no;
    @Expose
    private String isCover;

    public RegisterFpRequest(String sn, String employeeNo) {
        this(sn, employeeNo, null, null);
    }

    public RegisterFpRequest(String sn, String employeeNo, String no) {
        this(sn, employeeNo, no, null);
    }

    public RegisterFpRequest(String sn, String employeeNo, String no, String isCover) {
        this.sn = sn;
        this.employeeNo = employeeNo;
        this.no = no;
        this.isCover = isCover;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getIsCover() {
        return isCover;
    }

    public void setIsCover(String isCover) {
        this.isCover = isCover;
    }
}
