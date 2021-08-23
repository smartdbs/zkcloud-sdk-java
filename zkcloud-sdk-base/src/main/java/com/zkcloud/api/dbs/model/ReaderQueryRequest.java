package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class ReaderQueryRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 读头编号，当为空时，默认查询指定设备下的读头列表信息
     */
    @Expose
    private Integer readerNum;

    public ReaderQueryRequest(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getReaderNum() {
        return readerNum;
    }

    public void setReaderNum(Integer readerNum) {
        this.readerNum = readerNum;
    }
}
