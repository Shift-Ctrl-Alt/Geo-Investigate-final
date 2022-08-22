package com.oymn.geoinvestigatefinal.common.annotation;

import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CheckUserForAddImg {
}
