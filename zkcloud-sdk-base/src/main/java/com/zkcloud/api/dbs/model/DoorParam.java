package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

public  class DoorParam{
    @Expose
    private String name;

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