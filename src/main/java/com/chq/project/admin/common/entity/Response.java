package com.chq.project.admin.common.entity;

import java.io.Serializable;


/**
 * 接口返回类
 *
 * @author CHQ
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = 6138979130005367537L;

    private int code = 200;

    private boolean success = true;
    private T result;
    private String error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setResult(T result) {
        this.success = true;
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.success = false;
        this.error = error;
    }

    public static <T> Response<T> ok(T data) {
        Response<T> resp = new Response<T>();
        resp.setResult(data);
        return resp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

