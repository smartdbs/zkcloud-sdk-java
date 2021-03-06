package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

/**
 * 取消登记生物特征 请求参数
 */
public class CancelRegisterBiometricRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    public CancelRegisterBiometricRequest(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }
}
