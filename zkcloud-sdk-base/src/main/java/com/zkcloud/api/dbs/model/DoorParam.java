package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public  class DoorParam  extends AbstractModel {

    /**
     * 参数名
     */
    @Expose
    private String name;

    /**
     * 参数值
     */
    @Expose
    private String value;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public DoorParam(){}

    public DoorParam(String name, String value) {
        this.name = name;
        this.value = value;
    }
}