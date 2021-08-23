package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class UserInterLockDeleteRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 互锁详细信息编号集合
     */
    @Expose
   private Integer[] interLockNums;


    public UserInterLockDeleteRequest(String sn, Integer[] interLockNums) {
        this.sn = sn;
        this.interLockNums = interLockNums;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer[] getInterLockNums() {
        return interLockNums;
    }

    public void setInterLockNums(Integer[] interLockNums) {
        this.interLockNums = interLockNums;
    }
}