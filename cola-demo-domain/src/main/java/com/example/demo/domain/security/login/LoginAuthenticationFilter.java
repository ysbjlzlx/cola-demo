package com.example.demo.domain.security.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
public class LoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private static final AntPathRequestMatcher PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/api/login");

    public LoginAuthenticationFilter() {
        super(PATH_REQUEST_MATCHER);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        return null;
    }
}
