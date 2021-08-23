package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class FirstOpenDeleteRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 门编号，取值范围，1～4。当门编号为空或不传，则默认操作编号为1的门
     */
    @Expose
    private Integer[] doorNum;

    public FirstOpenDeleteRequest(String sn) {
        this.sn = sn;
    }

    public FirstOpenDeleteRequest(String sn, Integer[] doorNum) {
        this.sn = sn;
        this.doorNum = doorNum;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer[] getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(Integer[] doorNum) {
        this.doorNum = doorNum;
    }
}
