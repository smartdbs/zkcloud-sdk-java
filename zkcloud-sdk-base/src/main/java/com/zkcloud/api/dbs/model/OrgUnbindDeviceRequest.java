package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;
import java.util.List;

public class OrgUnbindDeviceRequest extends AbstractModel {

    @Expose
    private List<String> sns;

    @Expose
    private List<String> orgCodes;


    public OrgUnbindDeviceRequest(List<String> sns, List<String> orgCodes) {
        this.sns = sns;
        this.orgCodes = orgCodes;
    }

    public List<String> getSns() {
        return sns;
    }

    public void setSns(List<String> sns) {
        this.sns = sns;
    }

    public List<String> getOrgCodes() {
        return orgCodes;
    }

    public void setOrgCodes(List<String> orgCodes) {
        this.orgCodes = orgCodes;
    }
}
