package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class MultiGroupDeleteRequest extends AbstractModel {


    /**
     * 组合编号，企业内唯一
     */
    @Expose
    private Integer multiGroupNum;

    public MultiGroupDeleteRequest(Integer multiGroupNum) {
        this.multiGroupNum = multiGroupNum;
    }

    public Integer getMultiGroupNum() {
        return multiGroupNum;
    }

    public void setMultiGroupNum(Integer multiGroupNum) {
        this.multiGroupNum = multiGroupNum;
    }
}
