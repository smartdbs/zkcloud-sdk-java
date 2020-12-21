package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.List;

public class OrgDeleteBatchRequest extends AbstractModel {
    @Expose
    private List<OrgDeleteRequest> organizations;
    /**
      * 是否自动解绑该部门关联的员工，1:是，0:否（默认），若为否，则必须先解绑该组织架构关联的人员信息
      */
    @Expose
    private String autoUnbindEmployee;

    public OrgDeleteBatchRequest() {
    }

    public OrgDeleteBatchRequest(List<OrgDeleteRequest> organizations) {
        this(organizations, "0");
    }

    public OrgDeleteBatchRequest(List<OrgDeleteRequest> organizations, String autoUnbindEmployee) {
        this.organizations = organizations;
        this.autoUnbindEmployee = autoUnbindEmployee;
    }

    public List<OrgDeleteRequest> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<OrgDeleteRequest> organizations) {
        this.organizations = organizations;
    }

    public String getAutoUnbindEmployee() {
        return autoUnbindEmployee;
    }

    public void setAutoUnbindEmployee(String autoUnbindEmployee) {
        this.autoUnbindEmployee = autoUnbindEmployee;
    }
}
