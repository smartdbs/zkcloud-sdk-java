package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class AntiPassBackUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 反潜详细信息编号
     */
    @Expose
    private Integer antiPassBackNum;

    /**
     * 使用规则, 0:允许所有用户(默认), 1:仅允许(更新用户反潜信息)中满足antiPassBackNum的用户工号使用, 2:除去(更新用户反潜信息)中满足antiPassBackNum的用户工号外的所有人使用
     */
    @Expose
    private Integer rule;

    /**
     * 重置时间, 默认值:0, 单位:分钟, 取值范围:0~180分钟
     */
    @Expose
    private Integer resetTime;

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
     * 触发点集合编号，该编号取自更新触发点集合
     */
    @Expose
    private Integer entryTriggerListNum;

    /**
     * 触发点集合编号
     */
    @Expose
    private Integer exitTriggerListNum;


    public AntiPassBackUpdateRequest(String sn, Integer antiPassBackNum, Integer entryTriggerListNum, Integer exitTriggerListNum) {
        this.sn = sn;
        this.antiPassBackNum = antiPassBackNum;
        this.entryTriggerListNum = entryTriggerListNum;
        this.exitTriggerListNum = exitTriggerListNum;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getAntiPassBackNum() {
        return antiPassBackNum;
    }

    public void setAntiPassBackNum(Integer antiPassBackNum) {
        this.antiPassBackNum = antiPassBackNum;
    }

    public Integer getRule() {
        return rule;
    }

    public void setRule(Integer rule) {
        this.rule = rule;
    }

    public Integer getResetTime() {
        return resetTime;
    }

    public void setResetTime(Integer resetTime) {
        this.resetTime = resetTime;
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

    public Integer getEntryTriggerListNum() {
        return entryTriggerListNum;
    }

    public void setEntryTriggerListNum(Integer entryTriggerListNum) {
        this.entryTriggerListNum = entryTriggerListNum;
    }

    public Integer getExitTriggerListNum() {
        return exitTriggerListNum;
    }

    public void setExitTriggerListNum(Integer exitTriggerListNum) {
        this.exitTriggerListNum = exitTriggerListNum;
    }
}