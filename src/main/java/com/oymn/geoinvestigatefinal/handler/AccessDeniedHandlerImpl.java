package com.oymn.geoinvestigatefinal.handler;

import com.alibaba.fastjson.JSONObject;
import com.oymn.geoinvestigatefinal.common.StatusCode;
import com.oymn.geoinvestigatefinal.util.WebUtil;
import com.oymn.geoinvestigatefinal.vo.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限不足处理器
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        //抛出权限不足异常
        Result result = Result.fail(StatusCode.ACCESS_DENIED.getCode(), StatusCode.ACCESS_DENIED.getMsg());
        WebUtil.renderString(response, JSONObject.toJSONString(result));
    }
}
