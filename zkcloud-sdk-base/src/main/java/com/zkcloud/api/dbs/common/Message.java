package com.zkcloud.api.dbs.common;

import com.google.gson.annotations.Expose;


public class Message<T> {
    @Expose
    protected String lang;
    @Expose
    protected String sid;
    @Expose
    protected String usr;
    @Expose
    protected String pwd;
    @Expose
    protected String mid;
    @Expose
    protected String code;
    @Expose
    protected String message;
    @Expose
    protected MessagePayload<T> payload;

    public Message() {
        this.payload = new MessagePayload<>();
    }

    public Message(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Message(MessagePayload<T> payload) {
        this.payload = payload;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessagePayload<T> getPayload() {
        return payload;
    }

    public void setPayload(MessagePayload<T> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Message{" +
                "lang='" + lang + '\'' +
                ", usr='" + usr + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mid='" + mid + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", payload=" + payload +
                '}';
    }

}
