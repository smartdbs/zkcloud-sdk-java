package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;
import java.util.List;

public class EmployeeBindDeviceRequest extends AbstractModel {
    /**
      * 设备序列号数组
      */
    @Expose
    private List<String> sns;

    /**
     * 员工工号数组，数组长度不超过100
     */
    @Expose
    private List<String> employeeNos;

    /**
     * 验证方式
     */
    @Expose
    private String deviceVerifyMode;

    /**
     * 员工在设备的权限，0:普通员工, 14:管理员
     */
    @Expose
    private String devicePermission;

    /**
     * 员工设备密码，当设备支持的员工设备密码为明文密码时传递。若不开启员工密码打卡，建议当员工是管理员时才设置员工设备密码
     */
    @Expose
    private String devicePassword;

    /**
     * 加密过后的员工设备密码，当设备支持的员工设备密码为加密密码时传递。算法：PBKDF2WithHmacSHA256，密文长度：32字节，迭代次数：1000
     */
    private String devicePasswordEncryption;

    /**
     * devicePasswordEncryption加密的盐值，devicePasswordEncryption不为空时必填
     */
    @Expose
    private String devicePasswordSalt;

    /**
     * 有效时间-开始时间，为空时默认即时生效
     */
    @Expose
    private String startDate;

    /**
     * 有效时间-截止时间，为空时默认自startDate开始永久有效
     */
    @Expose
    private String endDate;

    public EmployeeBindDeviceRequest(List<String> sns, List<String> employeeNos) {
        this.sns = sns;
        this.employeeNos = employeeNos;
    }

    public List<String> getSns() {
        return sns;
    }

    public void setSns(List<String> sns) {
        this.sns = sns;
    }

    public List<String> getEmployeeNos() {
        return employeeNos;
    }

    public void setEmployeeNos(List<String> employeeNos) {
        this.employeeNos = employeeNos;
    }

    public String getDeviceVerifyMode() {
        return deviceVerifyMode;
    }

    public void setDeviceVerifyMode(String deviceVerifyMode) {
        this.deviceVerifyMode = deviceVerifyMode;
    }

    public String getDevicePermission() {
        return devicePermission;
    }

    public void setDevicePermission(String devicePermission) {
        this.devicePermission = devicePermission;
    }

    public String getDevicePassword() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDevicePasswordSalt() {
        return devicePasswordSalt;
    }

    public void setDevicePasswordSalt(String devicePasswordSalt) {
        this.devicePasswordSalt = devicePasswordSalt;
    }

    public String getDevicePasswordEncryption() {
        return devicePasswordEncryption;
    }

    public void setDevicePasswordEncryption(String devicePasswordEncryption) {
        this.devicePasswordEncryption = devicePasswordEncryption;
    }
}
