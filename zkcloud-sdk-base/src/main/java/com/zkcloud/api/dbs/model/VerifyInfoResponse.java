package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class VerifyInfoResponse {

    @Expose
    private Integer facePhotoCount;

    @Expose
    private Integer fingerCount;

    @Expose
    private Integer faceCount;

    @Expose
    private Integer palmPrintCount;

    @Expose
    private String devicePermission;

    @Expose
    private String cardNo;

    @Expose
    private String devicePassword;

    @Expose
    private String deviceVerifyMode;

    public Integer getFacePhotoCount() {
        return facePhotoCount;
    }

    public void setFacePhotoCount(Integer facePhotoCount) {
        this.facePhotoCount = facePhotoCount;
    }

    public Integer getFingerCount() {
        return fingerCount;
    }

    public void setFingerCount(Integer fingerCount) {
        this.fingerCount = fingerCount;
    }

    public Integer getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(Integer faceCount) {
        this.faceCount = faceCount;
    }

    public String getDevicePermission() {
        return devicePermission;
    }

    public void setDevicePermission(String devicePermission) {
        this.devicePermission = devicePermission;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getDevicePassword() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    public String getDeviceVerifyMode() {
        return deviceVerifyMode;
    }

    public void setDeviceVerifyMode(String deviceVerifyMode) {
        this.deviceVerifyMode = deviceVerifyMode;
    }

    public Integer getPalmPrintCount() {
        return palmPrintCount;
    }

    public void setPalmPrintCount(Integer palmPrintCount) {
        this.palmPrintCount = palmPrintCount;
    }
}
