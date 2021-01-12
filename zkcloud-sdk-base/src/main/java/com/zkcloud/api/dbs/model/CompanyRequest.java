package com.zkcloud.api.dbs.model;


import cn.hutool.core.date.DateUtil;
import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class CompanyRequest extends AbstractModel {

    /**
     * 公司编码，唯一识别属性，可理解为第三方系统内公司唯一标识
     */
    @Expose
    private String companyCode;

    /**
     * 公司名称
     */
    @Expose
    private String companyName;

    /**
     * 公司所属国家编码，参考标准的国家代码,默认CN
     */
    @Expose
    private String countryCode;

    /**
     * 公司所属省
     */
    @Expose
    private String province;

    /**
     * 公司所属市
     */
    @Expose
    private String city;

    /**
     * 街道1
     */
    @Expose
    private String address1;

    /**
     * 街道2
     */
    @Expose
    private String address2;

    /**
     * 街道3
     */
    @Expose
    private String address3;

    /**
     * 公司logo，可下载的图片URL http 或 https地址
     */
    @Expose
    private String logo;

    /**
     * 公司网址
     */
    @Expose
    private String website;

    /**
     * 邮编
     */
    @Expose
    private String zip;

    /**
     * 公司联系电话
     */
    @Expose
    private String phone;

    /**
     * 公司联系邮箱
     */
    @Expose
    private String email;

    /**
     * 所属行业
     */
    @Expose
    private String industry;

    /**
     * 日期格式，用于界面日期格式显示，默认yyyy-MM-dd
     */
    @Expose
    private String dateFormat;

    /**
     * 时间格式，用于界面时间格式显示，默认HH:mm:ss
     */
    @Expose
    private String timeFormat;

    /**
     * 状态，1代表正常，0代表软删除(禁用), 默认1
     */
    @Expose
    private Short active;

    /**
     * 最后修改时间戳，用此判断是否做处理，精确到秒
     */
    @Expose
    private Long lastUpdateTimeStamp;

    /**
     * 联系人，姓
     */
    @Expose
    private String lastName;

    /**
     * 联系人，名
     */
    @Expose
    private String firstName;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public Short getActive() {
        return active;
    }

    public void setActive(Short active) {
        this.active = active;
    }

    public Long getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(Long lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }

    public CompanyRequest() {
    }

    public CompanyRequest(String companyCode, String companyName) {
        this(companyCode, companyName, null);

    }

    public CompanyRequest(String companyCode, String companyName, String email) {
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.email = email;
        this.lastUpdateTimeStamp = DateUtil.currentSeconds();
    }

    public CompanyRequest(String companyName) {
        this.companyName = companyName;
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
}
