package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class AuxOutQueryResponse {


    /**
     * 辅助输入编号,大于0
     */
    @Expose
    private Integer auxOutNum;

    /**
     * 辅助输出名称
     */
    @Expose
    private String auxOutName;

    /**
     * 辅助输出地址：对应控制器丝印:AUXOUT1/AUXOUT2/AUXOUT3/AUXOUT4, 值分别为1/2/3/4
     */
    @Expose
    private Integer address;

    /**
     * 时间段集合编号
     */
    @Expose
    private Integer timezoneNum;

    /**
     * 具体操作，0:无, 1:常开, 2:常闭
     */
    @Expose
    private Integer action;


    public Integer getAuxOutNum() {
        return auxOutNum;
    }

    public void setAuxOutNum(Integer auxOutNum) {
        this.auxOutNum = auxOutNum;
    }

    public String getAuxOutName() {
        return auxOutName;
    }

    public void setAuxOutName(String auxOutName) {
        this.auxOutName = auxOutName;
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

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }
}
