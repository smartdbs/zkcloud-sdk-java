package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import java.util.List;

public class NewFwVersionsResponse {
    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 新版本集合
     */
    @Expose
    private List<NewFwVersion> versions;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public List<NewFwVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<NewFwVersion> versions) {
        this.versions = versions;
    }
}
