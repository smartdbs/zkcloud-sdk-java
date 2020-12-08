package com.zkteco.dbs.client.model;

import lombok.Data;

import java.util.List;

@Data
public class DoorRealStatuss extends BaseModel {
    private List<DoorRealStatus> status;
}