package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class UserAntiPassBackDeleteRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 反潜详细信息编号集合
     */
    @Expose
    private Integer[] antiPassBackNums;


    public UserAntiPassBackDeleteRequest(String sn, Integer[] antiPassBackNums) {
        this.sn = sn;
        this.antiPassBackNums = antiPassBackNums;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer[] getAntiPassBackNums() {
        return antiPassBackNums;
    }

    public void setAntiPassBackNums(Integer[] antiPassBackNums) {
        this.antiPassBackNums = antiPassBackNums;
    }
}