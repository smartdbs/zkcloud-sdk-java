package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

/**
 * 登记生物特征 请求参数
 */
public class RegisterBiometricRequest extends AbstractModel {

    @Expose
    private String sn;

    @Expose
    private String employeeNo;

    @Expose
    private String type;

    @Expose
    private String no;

    @Expose
    private String isCover;

    public RegisterBiometricRequest(String sn, String employeeNo, String type) {
        this.sn = sn;
        this.employeeNo = employeeNo;
        this.type = type;
    }

    public RegisterBiometricRequest(String sn, String employeeNo, String type, String no, String isCover) {
        this.sn = sn;
        this.employeeNo = employeeNo;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
