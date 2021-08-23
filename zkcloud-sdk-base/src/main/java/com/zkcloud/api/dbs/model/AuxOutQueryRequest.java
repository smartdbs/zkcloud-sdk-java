package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class AuxOutQueryRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 辅助输出编号，当为空时，默认查询指定设备下的辅助输出列表信息
     */
    @Expose
    private Integer auxOutNum;


    public AuxOutQueryRequest(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getAuxOutNum() {
        return auxOutNum;
    }

    public void setAuxOutNum(Integer auxOutNum) {
        this.auxOutNum = auxOutNum;
    }
}
