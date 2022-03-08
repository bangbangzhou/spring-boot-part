package com.learn.springboot.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @program: demo11
 * @package: com.springboot.learn.api
 * @classname: ResultCode
 * @description:
 * @author: zbb
 * @create: 2022-03-07
 */
@Getter
@AllArgsConstructor
public enum  ResultCode implements  IResultCode{

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 业务异常
     */
    FAILURE(400, "业务异常"),
    /**
     * 服务异常
     */
    ERROR(500, "服务异常"),
    /**
     * 参数错误
     */
    GLOBAL_PARAM_ERROR(540, "参数错误");
    /**
     * 状态码
     */
    final int code;
    /**
     * 消息内容
     */
    final String msg;

}
