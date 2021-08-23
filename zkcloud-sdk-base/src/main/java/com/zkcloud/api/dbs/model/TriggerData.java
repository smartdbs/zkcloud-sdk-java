package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class TriggerData extends AbstractModel {

    /**
     * 功能类型, 0:门, 4:读头
     */
    @Expose
    private Integer type;

    /**
     * 触发点编号, 0:所有的门编号(doorNum)或者读头编号(readerNum);>0:指定的门编号(doorNum)或者读头编号(readerNum)
     */
    @Expose
    private Integer triggerNum;

    public TriggerData(Integer type, Integer triggerNum) {
        this.type = type;
        this.triggerNum = triggerNum;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTriggerNum() {
        return triggerNum;
    }

    public void setTriggerNum(Integer triggerNum) {
        this.triggerNum = triggerNum;
    }
}