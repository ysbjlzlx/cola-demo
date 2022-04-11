package com.example.demo.interceptor;

import com.alibaba.cola.dto.Response;
import com.example.demo.base.AuthContext;
import com.example.demo.base.contants.HttpHeaderConstants;
import com.example.demo.base.enums.BizExceptionEnums;
import com.example.demo.base.factories.ResponseFactory;
import com.example.demo.base.utils.JSONUtils;
import com.example.demo.domain.UserDTO;
import com.example.demo.domain.auth.service.UserTokenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author Where.LIU
 * @since 2022/4/11
 */
@Slf4j
@Component
public class ApiAuthInterceptor implements HandlerInterceptor {
    private static final String BEARER_TOKEN_PREFIX = "Bearer ";
    private final UserTokenService userTokenService;

    @Autowired
    public ApiAuthInterceptor(UserTokenService userTokenService) {
        this.userTokenService = userTokenService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader(HttpHeaderConstants.AUTHORIZATION);
        log.debug("authorization {}", authorization);
        if (StringUtils.startsWith(authorization, BEARER_TOKEN_PREFIX)) {
            String token = StringUtils.substringAfter(authorization, BEARER_TOKEN_PREFIX);
            UserDTO userDTO = userTokenService.getUserByToken(token);
            if (null != userDTO) {
                AuthContext.setUserId(userDTO.getId());
                log.info("{}", JSONUtils.toJSONString(userDTO));
                return true;
            }
        }
        dealInvalidTokenResponse(response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        AuthContext.removeUserId();
    }

    private void dealInvalidTokenResponse(HttpServletResponse response) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Response content = ResponseFactory.buildFailure(BizExceptionEnums.USER_INVALID_TOKEN);
        try {
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(Objects.requireNonNull(JSONUtils.toJSONString(content)).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.error("", e);
        }

    }
}
