package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class InterLockUpdateRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 互锁详细信息编号(设备内唯一)
     */
    @Expose
   private Integer interLockNum;

    /**
     * 使用规则, 0:允许所有用户(默认), 1:仅允许(更新用户互锁信息)中满足interLockNum的用户工号使用, 2:除去(更新用户互锁信息)中满足interLockNum的用户工号外的所有人使用
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
     * 触发点集合编号，该编号取自更新触发点集合
     */
    @Expose
    private Integer entryTriggerListNum;

    /**
     * 触发点集合编号
     */
    @Expose
    private Integer exitTriggerListNum;


    public InterLockUpdateRequest(String sn, Integer interLockNum, Integer entryTriggerListNum, Integer exitTriggerListNum) {
        this.sn = sn;
        this.interLockNum = interLockNum;
        this.entryTriggerListNum = entryTriggerListNum;
        this.exitTriggerListNum = exitTriggerListNum;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getInterLockNum() {
        return interLockNum;
    }

    public void setInterLockNum(Integer interLockNum) {
        this.interLockNum = interLockNum;
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