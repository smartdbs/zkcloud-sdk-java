package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DeviceQueryRequest extends AbstractModel {

    @Expose
    private String sn;

    @Expose
    private Integer needDetails;

    public DeviceQueryRequest() {

    }

    public DeviceQueryRequest(String sn) {
        this(sn, null);
    }

    public DeviceQueryRequest(Integer needDetails) {
        this(null, needDetails);
    }

    public DeviceQueryRequest(String sn, Integer needDetails) {
        this.sn = sn;
        this.needDetails = needDetails;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getNeedDetails() {
        return needDetails;
    }

    public void setNeedDetails(Integer needDetails) {
        this.needDetails = needDetails;
    }
}
