package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class UserInterLockUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 互锁详细信息编号
     */
    @Expose
   private Integer interLockNum;

    /**
     * 人员列表
     */
    @Expose
    private String[] employeeNos;

    public UserInterLockUpdateRequest(String sn, Integer interLockNum, String[] employeeNos) {
        this.sn = sn;
        this.interLockNum = interLockNum;
        this.employeeNos = employeeNos;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getInterLockNum() {
        return interLockNum;
    }

    public void setInterLockNum(Integer interLockNum) {
        this.interLockNum = interLockNum;
    }

    public String[] getEmployeeNos() {
        return employeeNos;
    }

    public void setEmployeeNos(String[] employeeNos) {
        this.employeeNos = employeeNos;
    }
}