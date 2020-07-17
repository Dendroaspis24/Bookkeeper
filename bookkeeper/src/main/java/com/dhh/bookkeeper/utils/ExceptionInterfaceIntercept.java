package com.dhh.bookkeeper.utils;

import com.dhh.bookkeeper.bookkeeper.Enum.ErrorCodeEnum;
import org.apache.log4j.Logger;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;



public class ExceptionInterfaceIntercept extends HandlerInterceptorAdapter implements InitializingBean {

    private static Logger logger = Logger.getLogger(ExceptionInterfaceIntercept.class);


/*    public RespResult exceptionHandler(HttpServletRequest request,DBKRuntimeException e){
       *//*     RespResult result = new RespResult();
            result.setStatus(false);
            ErrorCodeEnum errorCodeEnum = ErrorCodeEnum.valueOf(e.getMessage());
            result.setCode(errorCodeEnum.getErrorCode());
            result.setMessage(errorCodeEnum.getMessage());
            return result;*//*
        System.out.println("========异常拦截器======");

        return new RespResult();
    }*/

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("======================拦截器==");
        super.afterCompletion(request, response, handler, ex);
    }

    public void afterPropertiesSet() throws Exception {
        // TODO Auto-generated method stub

    }
}
