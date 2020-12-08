package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DeviceRefreshEmployeeRequest extends AbstractModel {

    @Expose
    private String sn;

    @Expose
    private String onlineCheck;


    public DeviceRefreshEmployeeRequest(String sn) {
        this.sn = sn;
    }

    public DeviceRefreshEmployeeRequest(String sn, String onlineCheck) {
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
