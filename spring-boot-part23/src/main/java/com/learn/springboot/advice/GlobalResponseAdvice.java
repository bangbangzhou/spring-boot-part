package com.learn.springboot.advice;

import com.springboot.learn.api.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: demo11
 * @package: com.springboot.learn.advice
 * @classname: GlobalResponseAdvice
 * @description:
 * @author: zbb
 * @create: 2022-03-08
 */
@Component
@ControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }
    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        //如果响应结果是JSON数据类型
        if(selectedContentType.equalsTypeAndSubtype(
                MediaType.APPLICATION_JSON)){
            int code= ((Result) body).getCode();
            if(code>0 && code<512) {
                //HTTP响应结果设置状态码，状态码就是IResultCode的code，二者达到统一
                response.setStatusCode(
                        HttpStatus.valueOf(((Result) body).getCode())
                );
            }
            return body;
        }
        return body;
    }
}
