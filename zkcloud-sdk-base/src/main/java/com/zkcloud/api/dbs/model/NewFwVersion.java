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

    /**
     * 描述
     */
    @Expose
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
