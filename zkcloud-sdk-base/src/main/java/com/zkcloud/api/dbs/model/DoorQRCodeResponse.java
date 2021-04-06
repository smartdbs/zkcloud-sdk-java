package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import java.util.List;

public class DoorQRCodeResponse {

    /**
      * 二维码密文
      */
    @Expose
    private String QRCode;

    public String getQRCode() {
        return QRCode;
    }

    public void setQRCode(String QRCode) {
        this.QRCode = QRCode;
    }
}
