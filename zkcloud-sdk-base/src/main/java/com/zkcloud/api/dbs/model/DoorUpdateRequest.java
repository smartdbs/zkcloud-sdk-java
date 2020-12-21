package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DoorUpdateRequest extends AbstractModel {

    /**
 　　* 设备序列号
     */
    @Expose
    private String sn;
    /**
     * 门编号，取值范围，1～4
     */
    @Expose
    private Integer doorNum;

    /**
     * 门名称
     */
    @Expose
    private String doorName;

    /**
     * 启用状态，0:停用，1:启用，为空时默认等于1
     */
    @Expose
    private Integer enable;

    /**
     * 硬件设备的门锁继电器的编号，为空时默认与doorNum一致
     */
    @Expose
    private Integer address;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(Integer doorNum) {
        this.doorNum = doorNum;
    }

    public String getDoorName() {
        return doorName;
    }

    public void setDoorName(String doorName) {
        this.doorName = doorName;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public DoorUpdateRequest(String sn, Integer doorNum, String doorName) {
        this.sn = sn;
        this.doorNum = doorNum;
        this.doorName = doorName;
    }
}
