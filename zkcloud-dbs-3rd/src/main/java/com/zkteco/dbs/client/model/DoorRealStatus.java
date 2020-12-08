package com.zkteco.dbs.client.model;

import lombok.Data;

@Data
public class DoorRealStatus  {

    private String sn;
    private String doorNum;
    private String sensor;
    private String relay;
    private String alarm;
    private String coerce;
    private String time;
}
