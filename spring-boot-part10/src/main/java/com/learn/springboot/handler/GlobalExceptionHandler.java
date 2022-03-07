package com.learn.springboot.handler;

import com.learn.springboot.exception.GlobalException;
import com.learn.springboot.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final String ERROR_VIEW = "error";
    @ExceptionHandler(value = GlobalException.class)
    public  Result<String> exceptionError(HttpServletRequest req, GlobalException e) throws Exception{
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName(ERROR_VIEW);
        Result<String> result = new Result<>();
        result.setTime( System.currentTimeMillis());
        result.setMsg(e.getMessage());
        result.setCode(404);
        result.setData(req.getRequestURL().toString());
        return result;
    }
}
