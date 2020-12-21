package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;

public class OrgUpdateResponse {

    /**
　　  * 组织架构编码
　　  */
    @Expose
    private String orgCode;
    /**
 　　 * 返回值编码,当且仅当code=00000000时表示消息处理成功
 　　 */
    @Expose
    private String code;

    /**
　　  * 消息内容
　　  */
    @Expose
    private String message;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
