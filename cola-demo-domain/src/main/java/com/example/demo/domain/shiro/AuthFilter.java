package com.example.demo.domain.shiro;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
public class AuthFilter extends BasicHttpAuthenticationFilter {
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        return super.executeLogin(request, response);
    }

    @Override
    protected String getAuthzHeader(ServletRequest request) {
        return super.getAuthzHeader(request);
    }
}
