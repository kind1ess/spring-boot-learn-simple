package com.kind1ess.controller;

import com.kind1ess.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    /*@ExceptionHandler(UserNotExistException.class)
    public @ResponseBody Map<String, Object> handleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }*/

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code","5xx");
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return "forward:/error";
    }
}
