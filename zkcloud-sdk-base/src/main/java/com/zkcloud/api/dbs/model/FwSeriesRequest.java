package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class FwSeriesRequest extends AbstractModel {

    /**
      * 固件版本系列编码
      */
    @Expose
    private String seriesNo;

    public String getSeriesNo() {
        return seriesNo;
    }

    public void setSeriesNo(String seriesNo) {
        this.seriesNo = seriesNo;
    }

    public FwSeriesRequest(String seriesNo) {
        this.seriesNo = seriesNo;
    }
}
