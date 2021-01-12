package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class NewFwVersion {
    /**
     * 固件版本号
     */
    @Expose
    private String version;

    /**
     * 文件路径
     */
    @Expose
    private String url;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
