package com.zkcloud.api.dbs.model;


import cn.hutool.core.date.DateUtil;
import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUpdateRequest extends AbstractModel {
    /**
     * 员工编号，长度不超过9字节
     */
    @Expose
    private String employeeNo;

    /**
     * 名
     */
    @Expose
    private String firstName;

    /**
     * 姓
     */
    @Expose
    private String lastName;

    /**
     * 格式化后的姓名，用于显示，长度不超过24字节
     */
    @Expose
    private String formattedName;

    /**
     * 状态，1代表正常，0代表软删除
     */
    @Expose
    private Short active;

    /**
     * 档案照, 支持URL(http/https)和base64
     */
    @Expose
    private String photo;

    /**
     * 性别, 1代表男性，2代表女性，3代表其他
     */
    @Expose
    private String gender;

    /**
     * 邮箱地址
     */
    @Expose
    private String email;

    /**
     * 联系电话、手机号码
     */
    @Expose
    private String phone;

    /**
     * 雇佣(入职)日期
     */
    @Expose
    private String hireDate;

    /**
     * 所属组织架构编码列表
     */
    @Expose
    private List organization;

    /**
     * 员工在设备的权限，0:普通员工(默认), 14:管理员
     */
    @Expose
    private String devicePermission;

    /**
     * 验证方式，默认=0，详见验证方式说明
     */
    @Expose
    private String deviceVerifyMode;

    /**
     * 员工设备密码，当设备支持的员工设备密码为明文密码时传递。若不开启员工密码打卡，建议当员工是管理员时才设置员工设备密码
     */
    @Expose
    private String devicePassword;

    /**
     * 加密过后的员工设备密码，当设备支持的员工设备密码为加密密码时传递。算法：PBKDF2WithHmacSHA256，密文长度：32字节，迭代次数：1000
     */
    @Expose
    private String devicePasswordEncryption;

    /**
     * devicePasswordEncryption加密的盐值，devicePasswordEncryption不为空时必填
     */
    @Expose
    private String devicePasswordSalt;

    /**
     * 人脸照片，用于人脸比对，支持URL(http/https)和base64
     */
    @Expose
    private String facePhoto;

    /**
     * 卡号
     */
    @Expose
    private String cardNo;

    /**
     * 第三方最后修改时间戳，若该时间戳小于或等于上一次该组织架构接收到的时间戳，则该数据不处理，但会返回成功编码
     */
    @Expose
    private Long lastUpdateTimeStamp;

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public List getOrganization() {
        return organization;
    }

    public void setOrganization(List organization) {
        this.organization = organization;
    }

    public String getDevicePermission() {
        return devicePermission;
    }

    public void setDevicePermission(String devicePermission) {
        this.devicePermission = devicePermission;
    }

    public String getDeviceVerifyMode() {
        return deviceVerifyMode;
    }

    public void setDeviceVerifyMode(String deviceVerifyMode) {
        this.deviceVerifyMode = deviceVerifyMode;
    }

    public String getDevicePassword() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    public String getDevicePasswordEncryption() {
        return devicePasswordEncryption;
    }

    public void setDevicePasswordEncryption(String devicePasswordEncryption) {
        this.devicePasswordEncryption = devicePasswordEncryption;
    }

    public String getDevicePasswordSalt() {
        return devicePasswordSalt;
    }

    public void setDevicePasswordSalt(String devicePasswordSalt) {
        this.devicePasswordSalt = devicePasswordSalt;
    }

    public String getFacePhoto() {
        return facePhoto;
    }

    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Long getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(Long lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public EmployeeUpdateRequest() {
    }

    public EmployeeUpdateRequest(String employeeNo, String firstName, String lastName) {
        this(employeeNo, firstName, lastName, lastName);
    }

    public EmployeeUpdateRequest(String employeeNo, String firstName, String lastName, String formattedName) {
        this.employeeNo = employeeNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.formattedName = formattedName;
        this.active = 1;
        this.lastUpdateTimeStamp = DateUtil.currentSeconds();
    }
}
