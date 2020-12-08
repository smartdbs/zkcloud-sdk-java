package com.zkteco.dbs.client.model;

import lombok.Data;

@Data
public class DeviceStatusChange extends BaseModel {
    private String sn;
    private Short status;
    private Long changeTimeStamp;
}
