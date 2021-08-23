package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;
import java.util.List;

public class ReaderParamQueryResponse extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 读头编号，取值范围根据读头参数查询返回结果
     */
    @Expose
    private Integer readerNum;

    /**
     * 读头参数列表
     */
    @Expose
    private List<ReaderParam> readerParams;

    public ReaderParamQueryResponse(String sn, Integer readerNum, List<ReaderParam> readerParams) {
        this.sn = sn;
        this.readerNum = readerNum;
        this.readerParams = readerParams;
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

    public List<ReaderParam> getReaderParams() {
        return readerParams;
    }

    public void setReaderParams(List<ReaderParam> readerParams) {
        this.readerParams = readerParams;
    }
}
