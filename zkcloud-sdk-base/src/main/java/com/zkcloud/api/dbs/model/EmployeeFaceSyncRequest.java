package com.zkcloud.api.dbs.model;


import com.google.gson.annotations.Expose;
import com.zkcloud.api.dbs.common.AbstractModel;

public class EmployeeFaceSyncRequest extends AbstractModel {

    /**
 　　* 员工编号
 　　*/
    @Expose
    private String employeeNo;

    /**
 　　* 人脸照片，用于人脸比对，支持URL(http/https)和base64
 　　*/
    @Expose
    private String facePhoto;

    public EmployeeFaceSyncRequest(String employeeNo, String facePhoto) {
        this.employeeNo = employeeNo;
        this.facePhoto = facePhoto;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getFacePhoto() {
        return facePhoto;
    }

    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }
}

