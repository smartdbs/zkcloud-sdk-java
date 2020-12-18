package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

public class PunchRecordVerifyResponse {

    /**
     * 打卡记录总数
     */
    @Expose
    private String punchRecordSum;

    public String getPunchRecordSum() {
        return punchRecordSum;
    }

    public void setPunchRecordSum(String punchRecordSum) {
        this.punchRecordSum = punchRecordSum;
    }
}
