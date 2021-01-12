package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;
import java.util.List;

public class DeviceUpgradeBatchRequest extends AbstractModel {

    /**
      * 设备序列号集合
      */
    @Expose
    private List<String> sns;

    /**
     * 目标版本号
     */
    @Expose
    private String version;

    public DeviceUpgradeBatchRequest(List<String> sns, String version) {
        this.sns = sns;
        this.version = version;
    }

    public List<String> getSns() {
        return sns;
    }

    public void setSns(List<String> sns) {
        this.sns = sns;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
