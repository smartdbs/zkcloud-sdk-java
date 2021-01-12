package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class DeviceUpgradeResponse {
    /**
     * 表示本次升级的动作id，调用方需要保存；
     * 可用于调用“升级历史”接口
     */
    @Expose
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
