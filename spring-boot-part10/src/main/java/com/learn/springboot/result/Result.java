package com.learn.springboot.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    public static final Integer SUCCESS = 200;
    public static final Integer FAILURE_ERROR = 404;
    private static final long serialVersionUID = 1L;
    /**
     * 代码
     */
    private int code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 时间
     */
    private long time;
    /**
     * 数据实体
     */
    private T data;
}
