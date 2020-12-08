package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

public class RegisterFpResponse {

    @Expose
    private String sessionId;


    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
