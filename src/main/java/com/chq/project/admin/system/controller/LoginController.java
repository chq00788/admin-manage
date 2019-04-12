package com.chq.project.admin.system.controller;


import com.chq.project.admin.common.entity.Response;
import com.chq.project.admin.common.utils.JwtUtil;
import com.chq.project.admin.system.model.UserModel;
import com.chq.project.admin.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author CHQ
 * @Description
 * @date 2019/4/2
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param user
     * @param response
     * @return
     */
    @PostMapping("/login")
    public Response<String> login(@RequestBody UserModel user, HttpServletResponse response) {
        Response<String> result = new Response<>();
        String realPassword = userService.getPassword(user.getUsername());
        if (realPassword == null) {
            result.setError("用户名或密码错误");
        } else if (!realPassword.equals(user.getPassword())) {
            result.setError("用户名或密码错误");
        } else {
            String token = JwtUtil.sign(user.getUsername(), realPassword);
            response.setHeader("auth-token", token);
            result.setResult(token);
        }
        return result;
    }

    /**
     * 用户登出
     *
     * @return
     */
    @PostMapping("/logout")
    public Response<String> logout() {
        Response<String> result = new Response<>();
        result.setResult("登出成功");
        return result;
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public Response<String> unauthorized(@PathVariable String message) {
        Response<String> result = new Response<>();
        result.setError(message);
        return result;
    }


}
