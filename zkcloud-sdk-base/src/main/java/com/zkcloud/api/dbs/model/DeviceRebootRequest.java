package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DeviceRebootRequest extends AbstractModel {
    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    public DeviceRebootRequest(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
