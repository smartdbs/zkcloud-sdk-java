package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class UserAntiPassBackUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 反潜详细信息编号
     */
    @Expose
    private Integer antiPassBackNum;

    /**
     * 人员列表
     */
    @Expose
    private String[] employeeNos;

    public UserAntiPassBackUpdateRequest(String sn, Integer antiPassBackNum, String[] employeeNos) {
        this.sn = sn;
        this.antiPassBackNum = antiPassBackNum;
        this.employeeNos = employeeNos;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getAntiPassBackNum() {
        return antiPassBackNum;
    }

    public void setAntiPassBackNum(Integer antiPassBackNum) {
        this.antiPassBackNum = antiPassBackNum;
    }

    public String[] getEmployeeNos() {
        return employeeNos;
    }

    public void setEmployeeNos(String[] employeeNos) {
        this.employeeNos = employeeNos;
    }
}