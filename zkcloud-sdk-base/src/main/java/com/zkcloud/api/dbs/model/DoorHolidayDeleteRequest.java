package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class DoorHolidayDeleteRequest extends AbstractModel {


    @Expose
    private List<String> holidayCodes;

    public DoorHolidayDeleteRequest(List<String> holidayCodes) {
        this.holidayCodes = holidayCodes;
    }

    public List<String> getHolidayCodes() {
        return holidayCodes;
    }

    public void setHolidayCodes(List<String> holidayCodes) {
        this.holidayCodes = holidayCodes;
    }
}
