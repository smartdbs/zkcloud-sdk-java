package com.zkcloud.api.dbs.common;

import com.zkcloud.api.dbs.model.User;

public abstract class AbstractModel {

    /**
     * 集成账号信息，创建公司时返回，或者在web控制台手动添加，此处密码为明文，sdk会自行动态加密
     */
    public User apiUser;

    public User getApiUser() {
        return apiUser;
    }

    public void setApiUser(User apiUser) {
        this.apiUser = apiUser;
    }
}
