package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

/**
 * 登记生物特征 响应参数
 */
public class RegisterBiometricResponse{

    /**
 　　* 会话唯一标识，每次登记生物特征sessionId都不一致
 　　*/
    @Expose
    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
