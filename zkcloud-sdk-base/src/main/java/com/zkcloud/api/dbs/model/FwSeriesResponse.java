package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import java.util.List;

public class FwSeriesResponse {

    /**
      * 设备序列号
      */
    @Expose
    private List<String> versionList;

    public List<String> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<String> versionList) {
        this.versionList = versionList;
    }
}
