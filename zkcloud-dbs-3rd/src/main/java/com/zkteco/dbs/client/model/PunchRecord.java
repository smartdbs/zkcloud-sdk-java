package com.zkteco.dbs.client.model;

import lombok.Data;

@Data
public class PunchRecord {
    private String sn;
    private String employeeNo;
    private Long punchTime;
    private String iso8601PunchTime;
    private String workCode;
    private String status;
}
