package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

public class DeviceQueryDetails {
    /**
     * 设备通讯协议，0 pull，1 push，2 best，3 ufo，4 best-w，5 best-t
     */
    @Expose
    private String protocol;

    /**
     * 协议版本
     */
    @Expose
    private String protocolVer;

    /**
     * 设备型号
     */
    @Expose
    private String model;

    /**
     * 设备MAC地址
     */
    @Expose
    private String macAddress;

    /**
     * 核验记录数
     */
    @Expose
    private Integer verifyRecords;

    /**
     * 人员数
     */
    @Expose
    private Integer userCount;

    /**
     * 人脸数
     */
    @Expose
    private Integer faceCount;

    /**
     * 指纹数
     */
    @Expose
    private Integer fingerCount;

    /**
     * 掌纹数
     */
    @Expose
    private Integer palmPrintCount;

    /**
     * 设备最新请求时间戳
     */
    @Expose
    private Object lastRequestTimeStamp;

    /**
     * 是否支持门禁功能，0 不支持，1支持，2未知
     */
    @Expose
    private String supportAcc;

    /**
     * 是否支持指纹，0 不支持，1支持，2未知
     */
    @Expose
    private String supportFinger;

    /**
     * 是否支持近红外人脸，0 不支持，1支持，2未知
     */
    @Expose
    private String supportFace;

    /**
     * 是否支持可见光人脸，0 不支持，1支持，2未知
     */
    @Expose
    private String supportFacePhoto;

    /**
     * 是否支持掌纹，0 不支持，1支持，2未知
     */
    @Expose
    private String supportPalmPrint;

    /**
     * 是否支持远程登记指纹，0 不支持，1支持，2未知
     */
    @Expose
    private String supportRemoteFinger;

    /**
     * 是否支持远程登记可见光人脸，0 不支持，1支持，2未知
     */
    @Expose
    private String supportRemoteFacePhoto;

    /**
     * 是否支持远程登记掌纹，0 不支持，1支持，2未知
     */
    @Expose
    private String supportRemotePalmPrint;

    /**
     * 是否支持远程登记近红外人脸，0不支持，1支持，2未知
     */
    @Expose
    private String supportRemoteFace;

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocolVer() {
        return protocolVer;
    }

    public void setProtocolVer(String protocolVer) {
        this.protocolVer = protocolVer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Integer getVerifyRecords() {
        return verifyRecords;
    }

    public void setVerifyRecords(Integer verifyRecords) {
        this.verifyRecords = verifyRecords;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(Integer faceCount) {
        this.faceCount = faceCount;
    }

    public Integer getFingerCount() {
        return fingerCount;
    }

    public void setFingerCount(Integer fingerCount) {
        this.fingerCount = fingerCount;
    }

    public String getSupportAcc() {
        return supportAcc;
    }

    public void setSupportAcc(String supportAcc) {
        this.supportAcc = supportAcc;
    }

    public Object getLastRequestTimeStamp() {
        return lastRequestTimeStamp;
    }

    public void setLastRequestTimeStamp(Object lastRequestTimeStamp) {
        this.lastRequestTimeStamp = lastRequestTimeStamp;
    }

    public String getSupportFinger() {
        return supportFinger;
    }

    public void setSupportFinger(String supportFinger) {
        this.supportFinger = supportFinger;
    }

    public String getSupportFace() {
        return supportFace;
    }

    public void setSupportFace(String supportFace) {
        this.supportFace = supportFace;
    }

    public String getSupportFacePhoto() {
        return supportFacePhoto;
    }

    public void setSupportFacePhoto(String supportFacePhoto) {
        this.supportFacePhoto = supportFacePhoto;
    }

    public String getSupportRemoteFinger() {
        return supportRemoteFinger;
    }

    public void setSupportRemoteFinger(String supportRemoteFinger) {
        this.supportRemoteFinger = supportRemoteFinger;
    }

    public String getSupportRemoteFacePhoto() {
        return supportRemoteFacePhoto;
    }

    public void setSupportRemoteFacePhoto(String supportRemoteFacePhoto) {
        this.supportRemoteFacePhoto = supportRemoteFacePhoto;
    }

    public Integer getPalmPrintCount() {
        return palmPrintCount;
    }

    public void setPalmPrintCount(Integer palmPrintCount) {
        this.palmPrintCount = palmPrintCount;
    }

    public String getSupportPalmPrint() {
        return supportPalmPrint;
    }

    public void setSupportPalmPrint(String supportPalmPrint) {
        this.supportPalmPrint = supportPalmPrint;
    }

    public String getSupportRemotePalmPrint() {
        return supportRemotePalmPrint;
    }

    public void setSupportRemotePalmPrint(String supportRemotePalmPrint) {
        this.supportRemotePalmPrint = supportRemotePalmPrint;
    }

    public String getSupportRemoteFace() {
        return supportRemoteFace;
    }

    public void setSupportRemoteFace(String supportRemoteFace) {
        this.supportRemoteFace = supportRemoteFace;
    }
}
