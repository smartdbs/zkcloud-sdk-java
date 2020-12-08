package com.zkcloud.api.dbs.common;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zkcloud.api.dbs.common.http.HttpConnection;
import com.zkcloud.api.dbs.common.profile.ClientProfile;
import com.zkcloud.api.dbs.exception.ZKCloudSDKException;
import okhttp3.Headers;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractClient {
    protected String endpoint;
    protected Credential credential;
    protected ClientProfile clientProfile;

    public Gson gson;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public AbstractClient(String endpoint, Credential credential) {
        this(endpoint, credential, new ClientProfile());
    }

    public ClientProfile getClientProfile() {
        return clientProfile;
    }

    public void setClientProfile(ClientProfile clientProfile) {
        this.clientProfile = clientProfile;
    }

    public AbstractClient(String endpoint, Credential credential, ClientProfile clientProfile) {
        this.endpoint = endpoint;
        this.credential = credential;
        this.clientProfile = clientProfile;
        this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    public String getBaseUrl() {
        return this.clientProfile.getHttpProfile().getProtocol() + endpoint;
    }


    public String baseRequest(String path, AbstractModel model) throws ZKCloudSDKException {

        Message<AbstractModel> request = new Message<>();
        request.setLang(clientProfile.getLanguage().toString());
        request.getPayload().setParams(model);

        if (model.getApiUser() != null) {
            request.setUsr(model.getApiUser().getUserName());
            request.setPwd(SecureUtil.md5(model.getApiUser().getPassword() + model.getApiUser().getUserName()));
        }

        return baseRequest(path, gson.toJson(request));
    }

    public String baseRequest(String path, AbstractModel model,MessagePayload messagePayload) throws ZKCloudSDKException {
        Message<AbstractModel> request = new Message<>();
        request.setLang(clientProfile.getLanguage().toString());
        //设置分页参数
        request.setPayload(messagePayload);
        request.getPayload().setParams(model);
        if (model.getApiUser() != null) {
            request.setUsr(model.getApiUser().getUserName());
            request.setPwd(SecureUtil.md5(model.getApiUser().getPassword() + model.getApiUser().getUserName()));
        }

        return baseRequest(path, gson.toJson(request));
    }

    public String baseRequest(String path, String json) throws ZKCloudSDKException {
        try {
            System.out.println("request:" + json);
            Map<String, String> headerMap = new HashMap<>();
            headerMap.put("Content-Type", "application/json");
            headerMap.put("Authorization", credential.getAccessToken());
            headerMap.put("Timestamp", DateUtil.currentSeconds() + "");
            Headers headers = Headers.of(headerMap);
            Response response = new HttpConnection().postRequest(getBaseUrl() + path, json, headers);
            String result = response.body().string();
            System.out.println("response:" + result);
            return result;
        } catch (IOException e) {
            throw new ZKCloudSDKException(e.getMessage());
        }
    }
}
