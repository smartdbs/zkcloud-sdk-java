package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DeviceReloadEmployeeRequest extends AbstractModel {
    /**
     * 设备序列号
     */
    @Expose
    private String sn;
    /**
     * 设备在线状态校验。0代表不校验设备状态，执行该操作，1代表设备在线才执行此操作(默认)
     */
    @Expose
    private String onlineCheck;


    public DeviceReloadEmployeeRequest(String sn) {
        this.sn = sn;
    }

    public DeviceReloadEmployeeRequest(String sn, String onlineCheck) {
        this.sn = sn;
        this.onlineCheck = onlineCheck;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getOnlineCheck() {
        return onlineCheck;
    }

    public void setOnlineCheck(String onlineCheck) {
        this.onlineCheck = onlineCheck;
    }
}
