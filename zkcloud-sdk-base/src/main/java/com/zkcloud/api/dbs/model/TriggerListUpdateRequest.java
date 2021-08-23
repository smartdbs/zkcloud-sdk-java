package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;
import java.util.List;

public class TriggerListUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 触发点集合编号（设备内唯一）
     */
    @Expose
    private Integer triggerListNum;

    @Expose
    private List<TriggerData> triggerDatas;

    public TriggerListUpdateRequest(String sn, Integer triggerListNum, List<TriggerData> triggerDatas) {
        this.sn = sn;
        this.triggerListNum = triggerListNum;
        this.triggerDatas = triggerDatas;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getTriggerListNum() {
        return triggerListNum;
    }

    public void setTriggerListNum(Integer triggerListNum) {
        this.triggerListNum = triggerListNum;
    }

    public List<TriggerData> getTriggerDatas() {
        return triggerDatas;
    }

    public void setTriggerDatas(List<TriggerData> triggerDatas) {
        this.triggerDatas = triggerDatas;
    }
}