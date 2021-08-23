package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;
import javax.xml.ws.soap.Addressing;

public class TodayNormalOpenRequest extends AbstractModel {

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
     * 操作者编号。建议该字段传人员编号或者有辨识度的管理员代号，同时建议传送该字段；该操作者编号将在常开后的门禁记录中携带返回，以便做后续操作记录追踪。
     */
    @Expose
    private String employeeNo;

    /**
     * 具体操作，“0”：禁用常开，“1”：开启常开（默认）
     */
    @Expose
    private String action;

    public TodayNormalOpenRequest(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public Integer getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(Integer doorNum) {
        this.doorNum = doorNum;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
