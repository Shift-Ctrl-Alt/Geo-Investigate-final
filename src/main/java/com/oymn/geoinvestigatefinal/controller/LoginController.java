package com.oymn.geoinvestigatefinal.controller;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.oymn.geoinvestigatefinal.common.RoleConstant;
import com.oymn.geoinvestigatefinal.common.StatusCode;
import com.oymn.geoinvestigatefinal.dao.exception.ConditionException;
import com.oymn.geoinvestigatefinal.dao.pojo.Role;
import com.oymn.geoinvestigatefinal.dao.pojo.User;
import com.oymn.geoinvestigatefinal.service.LoginService;
import com.oymn.geoinvestigatefinal.service.UserService;
import com.oymn.geoinvestigatefinal.util.RSAUtil;
import com.oymn.geoinvestigatefinal.util.TokenUtil;
import com.oymn.geoinvestigatefinal.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Api("登录注册的接口")
@RestController
@RequestMapping("/user")
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @Autowired
    private UserService userService;


    @ApiOperation("判断token是否过期")
    @PostMapping("/token/check")
    public Result<String> checkTokenStatus(String token){
        try {
            Algorithm algorithm = Algorithm.RSA256(RSAUtil.getPublicKey(), RSAUtil.getPrivateKey());

            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Date expireTime = jwt.getExpiresAt();
            
            System.out.println(expireTime);
            
            //token过期
            System.out.println(new Date());
            System.out.println(expireTime.compareTo(new Date()));
            if(expireTime.compareTo(new Date()) < 0){
                return Result.success("201");
            }else{
                return Result.success("200");
            }
            
        } catch (TokenExpiredException e) {
            //throw new ConditionException(StatusCode.TOKEN_EXPIRED.getCode(), StatusCode.TOKEN_EXPIRED.getMsg());
            return Result.success("201");
        }catch (Exception e){
            throw new ConditionException(StatusCode.TOKEN_ERROR.getCode(), StatusCode.TOKEN_ERROR.getMsg());
        }
    }

    /**
     * 管理员登录接口
     * @param user
     * @return
     * @throws Exception
     */
    @ApiOperation("后台管理员登录")
    @PostMapping("/system/login")
    public Result<String> loginManager(@RequestBody User user) throws Exception {
        List<Role> roles = userService.getRolesByUsername(user.getUsername());
        Set<String> roleSet = new HashSet<>();
        for (Role role : roles) {
            roleSet.add(role.getName());
        }
        
        if(!(roleSet.contains(RoleConstant.ADMINISTRATOR) || roleSet.contains(RoleConstant.SUPER_ADMINISTRATOR))){
            throw new ConditionException("该用户不是管理员");
        }

        String token = loginService.login(user);
        return Result.success(token);
    }

    /**
     * 管理员登出接口
     * @param request
     * @return
     */
    @ApiOperation("登出")
    @PostMapping("/system/logout")
    public Result logoutManager(HttpServletRequest request){
        loginService.logout(request);
        return Result.success();
    }

    /**
     * 登录接口
     * @param user 
     * @return
     */
    @ApiOperation("登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody User user) throws Exception {
        String token = loginService.login(user);
        return Result.success(token);
    }

    /**
     * 注册接口
     * @param user
     * @return
     */
    @ApiOperation("注册")
    @PostMapping("register")
    public Result register(@RequestBody User user){
        loginService.register(user);
        return Result.success();
    }

    /**
     * 登出接口
     * @param request
     * @return
     */
    @ApiOperation("登出")
    @PostMapping("logout")
    public Result logout(HttpServletRequest request){
        loginService.logout(request);
        return Result.success();
    }
}
