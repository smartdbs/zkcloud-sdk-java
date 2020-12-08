package com.zkteco.dbs.client.model;

import lombok.Data;

@Data
public class DoorTransactionRecord{
    private String sn;

    private String doorNum;

    private String operator;

    private String time;

    private String inOutState;

    private String eventCode;

    private String verified;
}
