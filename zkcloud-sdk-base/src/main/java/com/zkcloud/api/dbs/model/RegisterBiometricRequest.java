package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

/**
 * 登记生物特征 请求参数
 */
public class RegisterBiometricRequest extends AbstractModel {

    /**
     * 设备序列号
     */
    @Expose
    private String sn;

    /**
     * 员工工号
     */
    @Expose
    private String employeeNo;

    /**
     * 生物特征类型
     */
    @Expose
    private String type;

    /**
     * 生物具体个体编号
     * 【指纹】编号是： 0-9。对应的手指是：左手：小拇指/无名指/中指/食指/拇指，右手：拇指/食指/中指/无名指/小拇指；
     * 【指静脉】和指纹相同；
     * 【面部】no=0；
     * 【虹膜】no 按照 0 为左眼 1为右眼；
     * 【掌静脉】no=0;
     * 如果no 没有明确定义，则默认值为 0。
     */
    @Expose
    private String no;

    /**
     * 是否覆盖设备该生物特征信息，0代表不覆盖（默认），1代表覆盖
     */
    @Expose
    private String isCover;

    public RegisterBiometricRequest(String sn, String employeeNo, String type) {
        this.sn = sn;
        this.employeeNo = employeeNo;
        this.type = type;
    }

    public RegisterBiometricRequest(String sn, String employeeNo, String type, String no, String isCover) {
        this.sn = sn;
        this.employeeNo = employeeNo;
        this.type = type;
        this.no = no;
        this.isCover = isCover;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getIsCover() {
        return isCover;
    }

    public void setIsCover(String isCover) {
        this.isCover = isCover;
    }
}
