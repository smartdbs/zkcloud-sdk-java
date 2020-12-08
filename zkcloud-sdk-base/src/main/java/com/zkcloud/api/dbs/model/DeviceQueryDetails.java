package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

public class DeviceQueryDetails {

    @Expose
    private String protocol;
    @Expose
    private String protocolVer;
    @Expose
    private String model;
    @Expose
    private String macAddress;
    @Expose
    private Integer verifyRecords;
    @Expose
    private Integer userCount;
    @Expose
    private Integer faceCount;
    @Expose
    private Integer fingerCount;
    @Expose
    private Integer palmPrintCount;
    @Expose
    private Object lastRequestTimeStamp;
    @Expose
    private String supportAcc;
    @Expose
    private String supportFinger;
    @Expose
    private String supportFace;
    @Expose
    private String supportFacePhoto;
    @Expose
    private String supportPalmPrint;
    @Expose
    private String supportRemoteFinger;
    @Expose
    private String supportRemoteFacePhoto;
    @Expose
    private String supportRemotePalmPrint;

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
}
