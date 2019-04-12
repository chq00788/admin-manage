package com.chq.project.admin.common.exception;


import com.chq.project.admin.common.entity.Response;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author CHQ
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * hibernate validator 验证异常控制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Response<String> validationErrorHandler(BindException e) {
        Response<String> response = new Response<>();
        BindingResult br = e.getBindingResult();
        response.setError(br.getFieldError().getDefaultMessage());
        return response;
    }
}
