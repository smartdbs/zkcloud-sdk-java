package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class MultiGroupUpdateRequest extends AbstractModel {

    /**
     * 组合编号，企业内唯一
     */
    @Expose
    private Integer multiGroupNum;

    /**
     * 组合名称
     */
    @Expose
    private String multiGroupName;

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     *  门编号，取值范围，1～4。当门编号为空或不传，则默认操作编号为1的门
     */
    @Expose
    private Integer doorNum;

    /**
     *  多人开门人员组编号 列表，长度最大为5，各组中人员需都已下发至设备
     */
    @Expose
    private Integer[] groups;

    public MultiGroupUpdateRequest(Integer multiGroupNum, String sn, Integer doorNum, Integer[] groups) {
        this.multiGroupNum = multiGroupNum;
        this.sn = sn;
        this.doorNum = doorNum;
        this.groups = groups;
    }

    public Integer getMultiGroupNum() {
        return multiGroupNum;
    }

    public void setMultiGroupNum(Integer multiGroupNum) {
        this.multiGroupNum = multiGroupNum;
    }

    public String getMultiGroupName() {
        return multiGroupName;
    }

    public void setMultiGroupName(String multiGroupName) {
        this.multiGroupName = multiGroupName;
    }

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

    public Integer[] getGroups() {
        return groups;
    }

    public void setGroups(Integer[] groups) {
        this.groups = groups;
    }
}
