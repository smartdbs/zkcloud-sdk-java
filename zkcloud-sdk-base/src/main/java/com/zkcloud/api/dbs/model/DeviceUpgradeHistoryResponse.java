package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class DeviceUpgradeHistoryResponse{

    /**
      * 设备序列号
      */
    @Expose
    private String deviceSn;

    /**
     * 任务id
     */
    @Expose
    private String taskId;

    /**
     * 上一个固件版本
     */
    @Expose
    private String lastVersion;

    /**
     * 当前固件版本
     */
    @Expose
    private String currentVersion;

    /**
     * 升级状态：0-升级中；1-升级成功；2-升级失败；3-下载中；4-烧制中；5-升级超时
     */
    @Expose
    private Integer status;

    /**
     * 升级结果描述
     */
    @Expose
    private String description;

    /**
     * 操作者
     */
    @Expose
    private String creater;

    /**
     * 升级开始时间
     */
    @Expose
    private Long createTimestamp;

    /**
     * 升级预结束时间
     */
    @Expose
    private Long effectiveTimestamp;

    /**
     * 升级结束时间
     */
    @Expose
    private Long completionTimestamp;

    /**
     * 升级操作发起来源 0:软件 1:设备
     */
    @Expose
    private Integer source;

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(String lastVersion) {
        this.lastVersion = lastVersion;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Long createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

    public Long getEffectiveTimestamp() {
        return effectiveTimestamp;
    }

    public void setEffectiveTimestamp(Long effectiveTimestamp) {
        this.effectiveTimestamp = effectiveTimestamp;
    }

    public Long getCompletionTimestamp() {
        return completionTimestamp;
    }

    public void setCompletionTimestamp(Long completionTimestamp) {
        this.completionTimestamp = completionTimestamp;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
