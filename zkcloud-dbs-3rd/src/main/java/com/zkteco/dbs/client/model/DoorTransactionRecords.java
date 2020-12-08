package com.zkteco.dbs.client.model;

import lombok.Data;

import java.util.List;

@Data
public class DoorTransactionRecords extends BaseModel {
    private List<DoorTransactionRecord>  transactions;
}
