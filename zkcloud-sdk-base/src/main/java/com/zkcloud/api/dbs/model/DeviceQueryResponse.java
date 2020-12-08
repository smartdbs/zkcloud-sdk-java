package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class DeviceQueryResponse {

    @Expose
    private String sn;
    @Expose
    private String timezone;
    @Expose
    private String alais;
    @Expose
    private Integer status;
    @Expose
    private Integer enable;
    @Expose
    private String localIp;
    @Expose
    private String remoteIp;
    @Expose
    private String fwVersion;
    @Expose
    private String model;
    @Expose
    private String type;
    @Expose
    private DeviceQueryDetails details;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getAlais() {
        return alais;
    }

    public void setAlais(String alais) {
        this.alais = alais;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public String getFwVersion() {
        return fwVersion;
    }

    public void setFwVersion(String fwVersion) {
        this.fwVersion = fwVersion;
    }

    public DeviceQueryDetails getDetails() {
        return details;
    }

    public void setDetails(DeviceQueryDetails details) {
        this.details = details;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
