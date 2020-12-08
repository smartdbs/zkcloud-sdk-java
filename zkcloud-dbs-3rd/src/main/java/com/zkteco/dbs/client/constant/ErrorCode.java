package com.zkteco.dbs.client.constant;

public enum ErrorCode {
    CODE_SUCCESS("00000000", "success"),
    CODE_NOT_SUPPORT("E0000001", "not exist service"),
    CODE_INVALID("E0000002", "invalid request"),
    CODE_ERROR_SIGN("E0000003", "error sign"),
    CODE_ERROR_PARAM_TYPE("E0000004", "param type error"),
    CODE_ERROR_PARAM_NOT_READ("E0000005", "param convert exception"),
    CODE_ERROR_GLOBAL_EXCEPTION("E0000006", "other exception");

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
