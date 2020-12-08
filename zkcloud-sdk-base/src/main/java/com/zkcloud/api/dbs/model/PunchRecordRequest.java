package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class PunchRecordRequest extends AbstractModel {

    @Expose
    private Long startTime;

    @Expose
    private Long endTime;

    @Expose
    private Long pushStartTime;

    @Expose
    private Long pushEndTime;

    public PunchRecordRequest(){

    }

    public PunchRecordRequest(Long pushStartTime, Long pushEndTime){
        this(null,null,pushStartTime, pushEndTime);
    }

    public PunchRecordRequest(Long startTime, Long endTime, Long pushStartTime, Long pushEndTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.pushStartTime = pushStartTime;
        this.pushEndTime = pushEndTime;
    }
}
