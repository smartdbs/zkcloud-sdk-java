package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

/**
 * 查询设备上的员工核验信息 请求参数
 */
public class VerifyInfoByDeviceRequest extends AbstractModel {

    /**
 　　* 员工编号,当employeeNo为空则查询该设备下所有人员的核验信息
 　　*/
    @Expose
    private String employeeNo;

    /**
 　　* 设备序列号
 　　*/
    @Expose
    private String sn;

    /**
 　　* 分页查询条件，分页页码，默认第1页
 　　*/
    @Expose(serialize = false)
    private Integer curPage;

    /**
 　　* 分页查询条件，分页大小，默认每页10条，不超过20条
 　　*/
    @Expose(serialize = false)
    private Integer pageSize;

    public VerifyInfoByDeviceRequest(String sn) {
        this.sn = sn;
    }

    public VerifyInfoByDeviceRequest(String employeeNo, String sn, Integer curPage, Integer pageSize) {
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
