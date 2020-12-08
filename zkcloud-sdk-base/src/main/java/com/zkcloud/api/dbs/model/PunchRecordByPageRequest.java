package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

/**
 * 分页获取设备打卡记录 请求参数
 */
public class PunchRecordByPageRequest extends AbstractModel {

    @Expose
    private Long startTime;

    @Expose
    private Long endTime;

    @Expose
    private Long pushStartTime;

    @Expose
    private Long pushEndTime;

    @Expose(serialize = false)
    private Integer curPage;

    @Expose(serialize = false)
    private Integer pageSize;

    public PunchRecordByPageRequest() {
    }

    public PunchRecordByPageRequest(Long startTime, Long endTime, Long pushStartTime, Long pushEndTime, Integer curPage, Integer pageSize) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.pushStartTime = pushStartTime;
        this.pushEndTime = pushEndTime;
        this.curPage = curPage;
        this.pageSize = pageSize;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getPushStartTime() {
        return pushStartTime;
    }

    public void setPushStartTime(Long pushStartTime) {
        this.pushStartTime = pushStartTime;
    }

    public Long getPushEndTime() {
        return pushEndTime;
    }

    public void setPushEndTime(Long pushEndTime) {
        this.pushEndTime = pushEndTime;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
