package com.chq.project.admin.common.exception;

/**
 * @author CHQ
 * @Description 未认证异常
 * @date 2019/4/4
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
