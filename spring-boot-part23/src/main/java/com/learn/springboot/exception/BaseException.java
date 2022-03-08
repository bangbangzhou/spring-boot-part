package com.learn.springboot.exception;

import lombok.Data;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @program: demo11
 * @package: com.springboot.learn.exception
 * @classname: BaseException
 * @description:
 * @author: zbb
 * @create: 2022-03-08
 */
@Data
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 5782968730281544562L;

    private int status = INTERNAL_SERVER_ERROR.value();
    public BaseException() {
    }
    public BaseException(String message) {
        super(message);
    }

    public BaseException(int status, String message) {
        super(message);
        this.status = status;
    }
}