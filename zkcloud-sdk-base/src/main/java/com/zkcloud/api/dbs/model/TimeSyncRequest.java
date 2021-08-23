package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public  class TimeSyncRequest  extends AbstractModel {

    @Expose
    private String sn;

    @Expose
    private String onlineCheck;

    public TimeSyncRequest(String sn) {
        this.sn = sn;
    }

    public TimeSyncRequest() {
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