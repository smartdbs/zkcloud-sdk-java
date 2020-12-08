package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

/**
 * 查询员工所在设备的核验信息 请求参数
 */
public class VerifyInfoByEmployeeRequest extends AbstractModel {

    @Expose
    private String employeeNo;

    @Expose
    private String sn;

    @Expose(serialize = false)
    private Integer curPage;

    @Expose(serialize = false)
    private Integer pageSize;

    public VerifyInfoByEmployeeRequest(String sn) {
        this.sn = sn;
    }

    public VerifyInfoByEmployeeRequest(String employeeNo, String sn, Integer curPage, Integer pageSize) {
        this.employeeNo = employeeNo;
        this.sn = sn;
        this.curPage = curPage;
        this.pageSize = pageSize;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
