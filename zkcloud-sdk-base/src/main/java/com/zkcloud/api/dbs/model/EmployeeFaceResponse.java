package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

/**
 * 查询员工人脸照片 响应参数
 */
public class EmployeeFaceResponse {

    @Expose
    private String facePhoto;

    public String getFacePhoto() {
        return facePhoto;
    }

    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }
}
