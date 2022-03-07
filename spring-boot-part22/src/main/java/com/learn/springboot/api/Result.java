package com.learn.springboot.api;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Data
@Getter
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;


    private long time;


    private T data;

    private Result() {
        this.time = System.currentTimeMillis();
    }

    private Result(IResultCode resultCode) {
        this(resultCode, null, resultCode.getMsg());
    }

    private Result(IResultCode resultCode, String msg) {
        this(resultCode, null, msg);
    }

    private Result(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMsg());
    }

    private Result(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.time = System.currentTimeMillis();
    }

    /**
     * 返回状态码
     *
     * @param resultCode 状态码
     * @param <T>        泛型标识
     * @return ApiResult
     */
    public static <T> Result<T> success(IResultCode resultCode) {
        return new Result<>(resultCode);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(ResultCode.SUCCESS, msg);
    }

    public static <T> Result<T> success(IResultCode resultCode, String msg) {
        return new Result<>(resultCode, msg);
    }

    public static <T> Result<T> data(T data) {
        return data(data, "处理成功");
    }

    public static <T> Result<T> data(T data, String msg) {
        return data(ResultCode.SUCCESS.code, data, msg);
    }

    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result<>(code, data, data == null ? "承载数据为空" : msg);
    }

    public static <T> Result<T> fail() {
        return new Result<>(ResultCode.FAILURE, ResultCode.FAILURE.getMsg());
    }

    public static <T> Result<T> fail(String msg) {
        return new Result<>(ResultCode.FAILURE, msg);
    }

    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, null, msg);
    }

    public static <T> Result<T> fail(IResultCode resultCode) {
        return new Result<>(resultCode);
    }

    public static <T> Result<T> fail(IResultCode resultCode, String msg) {
        return new Result<>(resultCode, msg);
    }

    public static <T> Result<T> condition(boolean flag) {
        return flag ? success("处理成功") : fail("处理失败");
    }
}