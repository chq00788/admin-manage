package com.chq.project.admin.system.controller;

import com.chq.project.admin.common.entity.Response;
import com.chq.project.admin.common.exception.UnauthorizedException;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author CHQ
 * @Description
 * @date 2019/4/12
 */
@RestControllerAdvice
public class ExceptionController {
    /**
     * 捕捉shiro的异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Response<String> handle401(ShiroException e) {
        Response<String> response = new Response<>();
        response.setError("暂无权限");
        response.setCode(401);
        return response;
    }

    /**
     * // 捕捉UnauthorizedException
     *
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Response<String> handle401() {
        Response<String> response = new Response<>();
        response.setError("暂无权限");
        response.setCode(401);
        return response;
    }

    /**
     * // 捕捉其他所有异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<String> globalException(HttpServletRequest request, Throwable ex) {
        Response<String> response = new Response<>();
        response.setError("系统错误");
        response.setCode(500);
        ex.printStackTrace();
        return response;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}
