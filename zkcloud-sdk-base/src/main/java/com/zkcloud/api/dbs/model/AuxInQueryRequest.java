package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class AuxInQueryRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 辅助输入编号，当为空时，默认查询指定设备下的辅助输入列表信息
     */
    @Expose
    private Integer auxInNum;

    public AuxInQueryRequest(String sn) {
        this.sn = sn;
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
}