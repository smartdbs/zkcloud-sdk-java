package com.zkteco.dbs.client.model;

import lombok.Data;

@Data
public class RegisterFpTip extends BaseModel {
    private String sn;
    private String sessionId;
    private String num;
    private String code;
    private String message;
    private String end;
}
