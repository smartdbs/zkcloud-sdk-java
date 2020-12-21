package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

/**
 * 分页查询设备命令 响应参数
 */
public class CommandListByPageResponse{

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 设备协议；push、best
     */
    @Expose
    private String protocol;

    /**
     * 命令创建时间
     */
    @Expose
    private Long commitTime;

    /**
     * 命令详情
     */
    @Expose
    private String content;

    /**
     * 设备回复时间
     */
    @Expose
    private Long returnTime;

    /**
     * 设备回复值，一般为 0 为成功，非 0 为失败
     */
    @Expose
    private String returnValue;

    /**
     * 命令状态；0: 未取走(默认) 1: 已取走未回复 2: 已回复 3: 已清除
     */
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
