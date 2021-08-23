package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class OpenDoorRequest extends AbstractModel {
    /**
 　  * 设备序列号
  　 */
    @Expose
    private String sn;

    /**
 　  * 门编号，取值范围，1～4。当门编号为空或不传，则默认开启编号为1的门
 　  */
    @Expose
    private Integer doorNum;

    /**
 　  * 操作者员工编号
 　  */
    @Expose
    private String employeeNo;

    public OpenDoorRequest(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Integer getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(Integer doorNum) {
        this.doorNum = doorNum;
    }
}
