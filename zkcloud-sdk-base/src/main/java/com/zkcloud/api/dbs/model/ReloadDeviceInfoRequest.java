package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class ReloadDeviceInfoRequest extends AbstractModel {

    /**
 　　* 设备序列号
 　　*/
    @Expose
    private String sn;

    /**
     * 设备在线状态校验。“0”代表不校验设备状态，执行该操作，“1”代表设备在线才执行此操作(默认)
     */
    @Expose
    private String onlineCheck;


    public ReloadDeviceInfoRequest(String sn) {
        this.sn = sn;
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
