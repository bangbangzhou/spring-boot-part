package com.learn.springboot.exception;

import lombok.Data;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @program: demo11
 * @package: com.springboot.learn.exception
 * @classname: ValidateCodeException
 * @description:
 * @author: zbb
 * @create: 2022-03-08
 */
@Data
public class ValidateCodeException extends RuntimeException {

    private static final long serialVersionUID = -7285211528095468156L;
    private int status = INTERNAL_SERVER_ERROR.value();
    public ValidateCodeException() {
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }

    public ValidateCodeException(int code, String message) {
        super(message);
        this.status = code;
    }
}
