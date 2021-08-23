package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class TriggerListDeleteRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 删除触发点集合
     */
    @Expose
    private Integer[] triggerListNums;

    public TriggerListDeleteRequest(String sn, Integer[] triggerListNums) {
        this.sn = sn;
        this.triggerListNums = triggerListNums;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer[] getTriggerListNums() {
        return triggerListNums;
    }

    public void setTriggerListNums(Integer[] triggerListNums) {
        this.triggerListNums = triggerListNums;
    }
}