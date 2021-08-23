package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class FirstOpenUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 门编号，取值范围，1～4。当门编号为空或不传，则默认操作编号为1的门
     */
    @Expose
    private Integer doorNum;

    /**
     * 人员列表，列表长度最大10
     */
    @Expose
    private String[] employeeNos;

    /**
     * 时间段集合编号
     */
    @Expose
    private Integer timezoneNum;

    public FirstOpenUpdateRequest(String sn, String[] employeeNos, Integer timezoneNum) {
        this.sn = sn;
        this.employeeNos = employeeNos;
        this.timezoneNum = timezoneNum;
    }

    public FirstOpenUpdateRequest(String sn, Integer doorNum, String[] employeeNos, Integer timezoneNum) {
        this.sn = sn;
        this.doorNum = doorNum;
        this.employeeNos = employeeNos;
        this.timezoneNum = timezoneNum;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(Integer doorNum) {
        this.doorNum = doorNum;
    }

    public String[] getEmployeeNos() {
        return employeeNos;
    }

    public void setEmployeeNos(String[] employeeNos) {
        this.employeeNos = employeeNos;
    }

    public Integer getTimezoneNum() {
        return timezoneNum;
    }

    public void setTimezoneNum(Integer timezoneNum) {
        this.timezoneNum = timezoneNum;
    }
}
