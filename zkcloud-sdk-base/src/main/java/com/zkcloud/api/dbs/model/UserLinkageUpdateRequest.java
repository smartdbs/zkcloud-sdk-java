package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class UserLinkageUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 联动详细信息编号（设备内唯一）
     */
    @Expose
    private Integer linkageNum;

    /**
     * 人员列表
     */
    @Expose
    private String[] employeeNos;


    public UserLinkageUpdateRequest(String sn, Integer linkageNum, String[] employeeNos) {
        this.sn = sn;
        this.linkageNum = linkageNum;
        this.employeeNos = employeeNos;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getLinkageNum() {
        return linkageNum;
    }

    public void setLinkageNum(Integer linkageNum) {
        this.linkageNum = linkageNum;
    }

    public String[] getEmployeeNos() {
        return employeeNos;
    }

    public void setEmployeeNos(String[] employeeNos) {
        this.employeeNos = employeeNos;
    }
}