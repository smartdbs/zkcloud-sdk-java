package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class OrgUpdateBatchRequest extends AbstractModel {
    @Expose
    private List<OrgUpdateRequest> organizations;

    public List<OrgUpdateRequest> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<OrgUpdateRequest> organizations) {
        this.organizations = organizations;
    }

    public OrgUpdateBatchRequest() {
    }

    public OrgUpdateBatchRequest(List<OrgUpdateRequest> organizations) {
        this.organizations = organizations;
    }
}
