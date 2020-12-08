package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

/**
 * 分页查询设备命令 响应参数
 */
public class CommandListByPageResponse{

    @Expose
    private String sn;

    @Expose
    private String protocol;

    @Expose
    private Long commitTime;

    @Expose
    private String content;

    @Expose
    private Long returnTime;

    @Expose
    private String returnValue;

    @Expose
    private String status;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Long getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Long commitTime) {
        this.commitTime = commitTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Long returnTime) {
        this.returnTime = returnTime;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
