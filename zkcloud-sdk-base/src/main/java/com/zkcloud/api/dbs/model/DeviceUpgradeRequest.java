package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DeviceUpgradeRequest extends AbstractModel {

    /**
      * 设备序列号
      */
    @Expose
    private String sn;

    /**
     * 目标版本号
     */
    @Expose
    private String version;

    public DeviceUpgradeRequest(String sn, String version) {
        this.sn = sn;
        this.version = version;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
