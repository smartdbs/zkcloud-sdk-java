package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class DeviceUpgradeHistoryRequest extends AbstractModel {

    /**
      * 设备序列号
      */
    @Expose
    private String sn;

    /**
     * 创建时间的开始时间
     */
    @Expose
    private Long beginTime;

    /**
     * 创建时间的结束时间
     */
    @Expose
    private Long endTime;

    /**
     * 任务Id
     */
    @Expose
    private String taskId;

    /**
     * 分页查询条件，分页页码，默认第1页
     */
    @Expose
    private Integer curPage;

    /**
     * 分页查询条件，分页大小，默认每页10条，不超过20条
     */
    @Expose
    private Integer pageSize;


    public DeviceUpgradeHistoryRequest(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
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
