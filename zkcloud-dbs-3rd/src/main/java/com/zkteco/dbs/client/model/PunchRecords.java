package com.zkteco.dbs.client.model;

import lombok.Data;

import java.util.List;

@Data
public class PunchRecords extends BaseModel {
    private List<PunchRecord> punchRecords;
}
