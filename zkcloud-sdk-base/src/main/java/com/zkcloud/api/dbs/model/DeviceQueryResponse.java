package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class DeviceQueryResponse {
    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 设备时区
     */
    @Expose
    private String timezone;

    /**
     * 设备别名
     */
    @Expose
    private String alais;

    /**
     * 设备在线状态，1代表在线，0代表离线
     */
    @Expose
    private Integer status;

    /**
     * 设备启用状态，1代表启用，0代表禁用
     */
    @Expose
    private Integer enable;

    /**
     * 设备内网Ip地址
     */
    @Expose
    private String localIp;

    /**
     * 设备公网Ip地址
     */
    @Expose
    private String remoteIp;

    /**
     * 设备固件版本号
     */
    @Expose
    private String fwVersion;

    /**
     * 设备型号
     */
    @Expose
    private String model;

    /**
     * 设备类型，0代表考勤设备，1代表门禁设备，999代表未知设备
     */
    @Expose
    private String type;

    /**
     * 设备详细信息，其他为设备基本信息
     */
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
