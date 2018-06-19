package com.example.constant;

public enum ControllerError {

    SYSTEM_ERROR(0, "系统异常"),
    PARAMETER_INVALID_ERROR(1, "非法参数"),
    NOT_PERMISSION_ERROR(2, "没有操作权限");

    private final int errorCode;
    private final String errorDesc;

    ControllerError(int errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public static ControllerError getControllerErrorByErrorCode(int errorCode) {
        for (ControllerError error : values()) {
            if (errorCode == error.getErrorCode()) {
                return error;
            }
        }
        return null;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
}
