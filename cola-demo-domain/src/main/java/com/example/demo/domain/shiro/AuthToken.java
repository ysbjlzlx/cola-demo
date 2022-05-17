package com.example.demo.domain.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
public class AuthToken implements AuthenticationToken {
    /**
     * 用户输入的账号
     */
    @Override
    public Object getPrincipal() {
        return null;
    }

    /**
     * 用户输入的密码
     */
    @Override
    public Object getCredentials() {
        return null;
    }
}
