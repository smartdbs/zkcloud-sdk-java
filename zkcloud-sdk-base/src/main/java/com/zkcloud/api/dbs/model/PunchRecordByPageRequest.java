package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

/**
 * 分页获取设备打卡记录 请求参数
 */
public class PunchRecordByPageRequest extends AbstractModel {


    /**
     * 打卡开始Unix时间戳，精确到秒（默认查询条件）
     */
    @Expose
    private Long startTime;

    /**
     * 打卡截止Unix时间戳，精确到秒，为空时默认当前时间（默认查询条件）
     */
    @Expose
    private Long endTime;

    /**
     * 开始Unix时间戳，精确到秒，此处指设备将记录推送到服务端的时间
     */
    @Expose
    private Long pushStartTime;

    /**
     * 截止Unix时间戳，精确到秒，此处指设备将记录推送到服务端的时间，为空时默认当前时间
     */
    @Expose
    private Long pushEndTime;

    /**
     * 分页查询条件，分页页码，默认第1页
     */
    @Expose(serialize = false)
    private Integer curPage;

    /**
     * 分页查询条件，分页大小，默认每页10条，不超过20条
     */
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
