package com.zkcloud.api.dbs.model;

import com.google.gson.annotations.Expose;

/**
 * 查询员工人脸照片 响应参数
 */
public class EmployeeFaceResponse {

    /**
 　　* 人脸照片的base64字符串
 　　*/
    @Expose
    private String facePhoto;

    public String getFacePhoto() {
        return facePhoto;
    }

    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }
}
