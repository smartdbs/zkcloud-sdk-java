package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class LinkageUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 联动详细信息编号（设备内唯一）
     */
    @Expose
    private Integer linkageNum;

    /**
     * 使用规则, 0:允许所有用户(默认), 1:仅允许(更新用户联动信息)中满足linkageNum的用户工号使用, 2:除去(更新用户联动信息)中满足linkageNum的用户工号外的所有人使用
     */
    @Expose
    private Integer rule;

    /**
     * 有效起始时间, I时间格式为ISO8601
     */
    @Expose
    private String startTime;

    /**
     * 有效结束时间, 时间格式为ISO8601
     */
    @Expose
    private String endTime;

    /**
     * 门禁时间段编号
     */
    @Expose
    private Integer timezoneNum;

    /**
     * 触发联动的事件类型，详见门禁实时事件码说明
     */
    @Expose
    private String linkageEventType;

    /**
     * 功能类型, 0:门, 1:辅助输入, 2:辅助输出, 4:读头, 255:任意
     */
    @Expose
    private Integer entryType;

    /**
     * 触发点编号, 0:所有的门编号(doorNum)或者辅助输入编号(auxInNum)或者辅助输出编号(auxOutNum)或者读头编号(readerNum)；
     *            >0:指定的门编号(doorNum)或者辅助输入编号(auxInNum)或者辅助输出编号(auxOutNum)或者读头编号(readerNum)
     */
    @Expose
    private Integer entryTriggerNum;

    /**
     * 功能类型, 0:门, 2:辅助输出, 255:任意
     */
    @Expose
    private Integer exitType;

    /**
     * 触发点编号, 0:所有的门编号(doorNum)或者辅助输出(auxOutNum)；>0:指定的门编号(doorNum)或者辅助输出(auxOutNum)
     */
    @Expose
    private Integer exitTriggerNum;

    /**
     * 开门\辅助输出时长, 0:关闭, 255:常开, 1-254:打开时长
     */
    @Expose
    private Integer delayTime;

    public LinkageUpdateRequest(String sn, Integer linkageNum, Integer entryType, Integer entryTriggerNum, Integer exitType,
            Integer exitTriggerNum, Integer delayTime) {
        this.sn = sn;
        this.linkageNum = linkageNum;
        this.entryType = entryType;
        this.entryTriggerNum = entryTriggerNum;
        this.exitType = exitType;
        this.exitTriggerNum = exitTriggerNum;
        this.delayTime = delayTime;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getLinkageNum() {
        return linkageNum;
    }

    public void setLinkageNum(Integer linkageNum) {
        this.linkageNum = linkageNum;
    }

    public Integer getRule() {
        return rule;
    }

    public void setRule(Integer rule) {
        this.rule = rule;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getTimezoneNum() {
        return timezoneNum;
    }

    public void setTimezoneNum(Integer timezoneNum) {
        this.timezoneNum = timezoneNum;
    }

    public String getLinkageEventType() {
        return linkageEventType;
    }

    public void setLinkageEventType(String linkageEventType) {
        this.linkageEventType = linkageEventType;
    }

    public Integer getEntryType() {
        return entryType;
    }

    public void setEntryType(Integer entryType) {
        this.entryType = entryType;
    }

    public Integer getEntryTriggerNum() {
        return entryTriggerNum;
    }

    public void setEntryTriggerNum(Integer entryTriggerNum) {
        this.entryTriggerNum = entryTriggerNum;
    }

    public Integer getExitType() {
        return exitType;
    }

    public void setExitType(Integer exitType) {
        this.exitType = exitType;
    }

    public Integer getExitTriggerNum() {
        return exitTriggerNum;
    }

    public void setExitTriggerNum(Integer exitTriggerNum) {
        this.exitTriggerNum = exitTriggerNum;
    }

    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
    }
}