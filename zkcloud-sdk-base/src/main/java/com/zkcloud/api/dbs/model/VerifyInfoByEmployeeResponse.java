package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

/**
 * 查询员工所在设备的核验信息 响应参数
 */
public class VerifyInfoByEmployeeResponse {

    /**
 　　* 设备序列号
 　　*/
    @Expose
    private String sn;

    /**
 　　* 面部（近红外人脸）数
 　　*/
    @Expose
    private int facePhotoCount;

    /**
 　　* 指纹数
 　　*/
    @Expose
    private int fingerCount;

    /**
 　　* 面部（近红外人脸）数
 　　*/
    @Expose
    private int faceCount;

    /**
 　　* 掌纹数
 　　*/
    @Expose
    private int palmPrintCount;

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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getFacePhotoCount() {
        return facePhotoCount;
    }

    public void setFacePhotoCount(int facePhotoCount) {
        this.facePhotoCount = facePhotoCount;
    }

    public int getFingerCount() {
        return fingerCount;
    }

    public void setFingerCount(int fingerCount) {
        this.fingerCount = fingerCount;
    }

    public int getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(int faceCount) {
        this.faceCount = faceCount;
    }

    public int getPalmPrintCount() {
        return palmPrintCount;
    }

    public void setPalmPrintCount(int palmPrintCount) {
        this.palmPrintCount = palmPrintCount;
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
}
