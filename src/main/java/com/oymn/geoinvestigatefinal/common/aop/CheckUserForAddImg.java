package com.oymn.geoinvestigatefinal.common.aop;

import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.dao.pojo.Record;
import com.oymn.geoinvestigatefinal.handler.UserSupport;
import com.oymn.geoinvestigatefinal.service.RecordService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckUserForAddImg {
    
    @Autowired
    private UserSupport userSupport;
    
    @Autowired
    private RecordService recordService;
    

    @Pointcut("@annotation(com.oymn.geoinvestigatefinal.common.annotation.CheckUserForAddImg)")
    public void check() {

    }

    @Before("check()")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        //获取当前登录的用户
        Long currentUserId = userSupport.getCurrentUserId();

        //获取参数值
        Object[] args = joinPoint.getArgs();

        //获取主记录的id
        Object parameterValue = args[0];
        
        Long recordId = (Long) parameterValue;

        Record record = recordService.getRecordById(recordId);
        if(record == null){
            throw new ConditionException("该记录不存在");
        }
        Long userId = record.getUserId();

        if(currentUserId != userId){
            throw new ConditionException("记录所有者不是该登录用户");
        }

    }
}
