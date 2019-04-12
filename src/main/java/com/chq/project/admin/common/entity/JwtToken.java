package com.chq.project.admin.common.entity;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author CHQ
 * @Description
 * @date 2019/4/2
 */
public class JwtToken implements AuthenticationToken {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
