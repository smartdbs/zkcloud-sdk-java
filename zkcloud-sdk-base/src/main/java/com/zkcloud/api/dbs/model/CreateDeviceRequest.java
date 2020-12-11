package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class CreateDeviceRequest extends AbstractModel {

    @Expose
    private String sn;

    @Expose
    private String timeZone;

    @Expose
    private String alais;

    @Expose
    private String timezone;

//    @Expose
//    private String fpFunOn;
//
//    @Expose
//    private String faceFunOn;
//
//    @Expose
//    private String punchPhotoFunOn;
//
//    @Expose
//    private String punchRecordFunOn;


    public CreateDeviceRequest(){}

    public CreateDeviceRequest(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getAlais() {
        return alais;
    }

    public void setAlais(String alais) {
        this.alais = alais;
    }

//    public String getFpFunOn() {
//        return fpFunOn;
//    }
//
//    public void setFpFunOn(String fpFunOn) {
//        this.fpFunOn = fpFunOn;
//    }
//
//    public String getFaceFunOn() {
//        return faceFunOn;
//    }
//
//    public void setFaceFunOn(String faceFunOn) {
//        this.faceFunOn = faceFunOn;
//    }
//
//    public String getPunchPhotoFunOn() {
//        return punchPhotoFunOn;
//    }
//
//    public void setPunchPhotoFunOn(String punchPhotoFunOn) {
//        this.punchPhotoFunOn = punchPhotoFunOn;
//    }
//
//    public String getPunchRecordFunOn() {
//        return punchRecordFunOn;
//    }
//
//    public void setPunchRecordFunOn(String punchRecordFunOn) {
//        this.punchRecordFunOn = punchRecordFunOn;
//    }


    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
