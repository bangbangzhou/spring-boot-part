package com.learn.springboot.api;

/**
 * 统一返回结果接口
 */
public interface IResultCode {


    /**
     * 返回码
     *
     * @return int
     */
    int getCode();

    /**
     * 返回消息
     *
     * @return String
     */
    String getMsg();
}
