package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorParamQueryRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 门编号，当为空时，默认查询指定设备下的门列表信息
     */
    @Expose
    private Integer doorNum;



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



    public DoorParamQueryRequest(String sn, Integer doorNum ) {
        this.sn = sn;
        this.doorNum = doorNum;
    }

    public DoorParamQueryRequest(String sn) {
        this.sn = sn;
        this.doorNum = null;
    }

}
