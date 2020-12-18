package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class VerifyInfoResponse {

    /**
 　　* 可见光人脸数
 　　*/
    @Expose
    private Integer facePhotoCount;

    /**
 　　* 指纹数
 　　*/
    @Expose
    private Integer fingerCount;

    /**
 　　* 面部（近红外人脸）数
 　　*/
    @Expose
    private Integer faceCount;

    /**
 　　* 掌纹数
 　　*/
    @Expose
    private Integer palmPrintCount;

    /**
 　　* 员工在设备的权限，0:普通员工(默认), 14:管理员
 　　*/
    @Expose
    private String devicePermission;

    /**
 　　* 卡号
 　　*/
    @Expose
    private String cardNo;

    /**
 　　* 员工设备密码
 　　*/
    @Expose
    private String devicePassword;

    /**
 　　* 验证方式
 　　*/
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
