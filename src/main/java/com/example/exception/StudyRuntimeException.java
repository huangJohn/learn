package com.example.exception;


import com.example.constant.ControllerError;

/**
 * 自定义异常
 */
public class StudyRuntimeException extends RuntimeException {
    /**
     * serialVersionUID
     */
    //异常码
    private ControllerError error;
    //异常描述
    private String errorMessage;

    //构造函数 idea自动生成

    /**
     * @param error 异常码枚举
     */
    public StudyRuntimeException(ControllerError error) {
        super(error.getErrorCode() + ":" + error.getErrorDesc());
        this.error = error;
        this.errorMessage = error.getErrorDesc();
    }

    public StudyRuntimeException(Throwable cause, ControllerError error) {
        super(error.getErrorCode() + ":" + error.getErrorDesc(), cause);
        this.error = error;
        this.errorMessage = error.getErrorDesc();
    }

    public StudyRuntimeException(ControllerError error, String errorMessage) {
        super(error.getErrorCode() + ":" + error.getErrorDesc());
        this.error = error;
        this.errorMessage = errorMessage;
    }


    public StudyRuntimeException(Throwable cause, ControllerError error, String errorMessage) {
        super(error.getErrorCode() + ":" + error.getErrorDesc(), cause);
        this.error = error;
        this.errorMessage = errorMessage;
    }


    @Override
    public String getMessage() {
        if (error == null) {
            return errorMessage;
        } else {
            return "Code :" + error.getErrorCode() + ", Desc :" + errorMessage;
        }
    }

    /**
     * Getter method for property <tt>error</tt>.
     *
     * @return property value of error
     */
    public ControllerError getError() {
        return error;
    }

    /**
     * Getter method for property <tt>errorMessage</tt>.
     *
     * @return property value of errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
