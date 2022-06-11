package com.modelsis.appproducts.exceptions;

import org.springframework.http.HttpStatus;

public class ApiRequestExecption extends RuntimeException{
    private final int code;
    private final ExceptionLevel level;
    private final HttpStatus httpStatus;

    public ApiRequestExecption(String message, int code, ExceptionLevel level) {
        super(message);

        this.code = code;
        this.level = level;
        this.httpStatus = HttpStatus.NOT_FOUND;
    }

    public ApiRequestExecption(String message, int code, ExceptionLevel level, HttpStatus httpStatus) {
        super(message);

        this.code = code;
        this.level = level;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public ExceptionLevel getLevel() {
        return level;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
