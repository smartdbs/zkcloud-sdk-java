package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class DeviceUpgradeBatchResponse{

    /**
      * 设备序列号
      */
    @Expose
    private String sn;

    /**
     * 结果编码
     */
    @Expose
    private String code;

    /**
     * 结果描述
     */
    @Expose
    private String message;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
