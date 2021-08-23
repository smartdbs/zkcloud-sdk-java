package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class UserLinkageDeleteRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 联动详细信息编号集合
     */
    @Expose
    private Integer[] linkageNums;

    public UserLinkageDeleteRequest(String sn, Integer[] linkageNums) {
        this.sn = sn;
        this.linkageNums = linkageNums;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer[] getLinkageNums() {
        return linkageNums;
    }

    public void setLinkageNums(Integer[] linkageNums) {
        this.linkageNums = linkageNums;
    }
}