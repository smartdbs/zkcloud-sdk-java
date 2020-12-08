package com.zkcloud.api.dbs.exception;

public class ZKCloudSDKException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String mid;

    private String code;

    public ZKCloudSDKException(String message) {
        this(message, "");
    }

    public ZKCloudSDKException(String message, String code) {
        this(message, code, "");
    }

    public ZKCloudSDKException(String message, String code, String mid) {
        super(message);
        this.code = code;
        this.mid = mid;
    }

    public String getMid() {
        return mid;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "[ZKCloudSDKException]" +
                " message=" + this.getMessage() +
                ",mid='" + mid + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
