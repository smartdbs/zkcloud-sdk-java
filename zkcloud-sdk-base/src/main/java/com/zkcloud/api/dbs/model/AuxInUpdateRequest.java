package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class AuxInUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 辅助输入编号,大于0
     */
    @Expose
    private Integer auxInNum;

    /**
     * 辅助输入名称
     */
    @Expose
    private String auxInName;

    /**
     * 辅助输入地址：对应控制器丝印:AUXIN1/AUXIN2/AUXIN3/AUXIN4, 值分别为1/2/3/4
     */
    @Expose
    private Integer address;

    /**
     * 时间段集合编号
     */
    @Expose
    private Integer timezoneNum;

    /**
     * 输入模式, 0:普通输入模式, 1:线路检测输入模式
     */
    @Expose
    private Integer inputMode;

    /**
     * 线路检测阻值, 1:1.2K电阻, 2:2.2K电阻, 3:4.7K电阻, 4:10K电阻；当输入模式为线路检测，则该字段为必传；
     */
    @Expose
    private Integer supervisedResistor;

    public AuxInUpdateRequest(String sn, Integer auxInNum) {
        this.sn = sn;
        this.auxInNum = auxInNum;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getAuxInNum() {
        return auxInNum;
    }

    public void setAuxInNum(Integer auxInNum) {
        this.auxInNum = auxInNum;
    }

    public String getAuxInName() {
        return auxInName;
    }

    public void setAuxInName(String auxInName) {
        this.auxInName = auxInName;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getTimezoneNum() {
        return timezoneNum;
    }

    public void setTimezoneNum(Integer timezoneNum) {
        this.timezoneNum = timezoneNum;
    }

    public Integer getInputMode() {
        return inputMode;
    }

    public void setInputMode(Integer inputMode) {
        this.inputMode = inputMode;
    }

    public Integer getSupervisedResistor() {
        return supervisedResistor;
    }

    public void setSupervisedResistor(Integer supervisedResistor) {
        this.supervisedResistor = supervisedResistor;
    }
}