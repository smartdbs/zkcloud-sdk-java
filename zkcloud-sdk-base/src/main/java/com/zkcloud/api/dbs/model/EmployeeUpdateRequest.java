package com.zkcloud.api.dbs.model;


import cn.hutool.core.date.DateUtil;
import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUpdateRequest extends AbstractModel {
    @Expose
    private String employeeNo;
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String formattedName;
    @Expose
    private Short active;
    @Expose
    private String photo;
    @Expose
    private String gender;
    @Expose
    private String email;
    @Expose
    private String phone;
    @Expose
    private String hireDate;
    @Expose
    private List organization;
    @Expose
    private String devicePermission;
    @Expose
    private String deviceVerifyMode;
    @Expose
    private String devicePassword;
    @Expose
    private String devicePasswordEncryption;
    @Expose
    private String devicePasswordSalt;
    @Expose
    private String facePhoto;
    @Expose
    private String cardNo;
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
