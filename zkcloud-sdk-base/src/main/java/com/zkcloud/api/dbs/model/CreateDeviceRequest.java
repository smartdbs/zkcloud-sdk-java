package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class CreateDeviceRequest extends AbstractModel {

    /**
 　　* 设备序列号
 　　*/
    @Expose
    private String sn;

    /**
 　　* 设备时区，为空时默认东八区，即+08:00
 　　*/
    @Expose
    private String timeZone;

    /**
 　　* 设备别名
 　　*/
    @Expose
    private String alais;

    /**
 　　* 夏令时时区id对应附录中的key
 　　*/
    @Expose
    private String timezone;


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


    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
