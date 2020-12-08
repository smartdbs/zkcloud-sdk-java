package com.zkteco.dbs.client.model;

import lombok.Data;

@Data
public class DeviceInit extends BaseModel {
    private String sn;
    private String timezone;
    private String alais;
    private Short status;
    private Short enable;
    private String remoteIp;
    private Long initTimeStamp;
}
