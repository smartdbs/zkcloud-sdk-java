package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

public  class DoorParam{

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

    public DoorParam(String name, String value) {
        this.name = name;
        this.value = value;
    }
}