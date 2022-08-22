package com.oymn.geoinvestigatefinal.handler;


import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)   //优先级是最高的
@Slf4j
public class CommonGlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result commonExceptionHandler(HttpServletRequest request, Exception e){
        String errorMsg = e.getMessage();
        e.printStackTrace();
        
        if(e instanceof ConditionException){
            int errorCode = ((ConditionException) e).getCode();
            return Result.fail(errorCode, errorMsg);
        }else{
            //普通异常
            return Result.fail(500, errorMsg);
        }
    }
}
