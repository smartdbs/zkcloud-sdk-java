package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

/**
 * 分页查询设备命令 请求参数
 */
public class CommandListByPageRequest extends AbstractModel {

    @Expose
    private String sn;

    @Expose
    private Long startTime;

    @Expose
    private Long endTime;

    @Expose
    private String status;

    @Expose(serialize = false)
    private Integer curPage;

    @Expose(serialize = false)
    private Integer pageSize;

    public CommandListByPageRequest(Long startTime) {
        this.startTime = startTime;
    }

    public CommandListByPageRequest(String sn, Long startTime, Long endTime, String status, Integer curPage, Integer pageSize) {
        this.sn = sn;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.curPage = curPage;
        this.pageSize = pageSize;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
