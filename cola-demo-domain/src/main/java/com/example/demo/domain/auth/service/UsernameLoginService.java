package com.example.demo.domain.auth.service;

import com.example.demo.base.enums.BizExceptionEnums;
import com.example.demo.base.factories.BizExceptionFactory;
import com.example.demo.domain.UserDTO;
import com.example.demo.domain.UserTokenDTO;
import com.example.demo.domain.auth.event.UserLoginFailureEvent;
import com.example.demo.domain.auth.request.UsernameLoginQry;
import com.example.demo.domain.gateway.UserInfoGatewayI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author where
 */
@Service
public class UsernameLoginService {
    private final ApplicationContext applicationContext;
    private final UserInfoGatewayI userInfoGatewayI;
    private final PasswordEncoder passwordEncoder;
    private final UserTokenService userTokenService;

    @Autowired
    public UsernameLoginService(ApplicationContext applicationContext,
                                UserInfoGatewayI userInfoGatewayI,
                                PasswordEncoder passwordEncoder,
                                UserTokenService userTokenService) {
        this.applicationContext = applicationContext;
        this.userInfoGatewayI = userInfoGatewayI;
        this.passwordEncoder = passwordEncoder;
        this.userTokenService = userTokenService;
    }

    public String login(UsernameLoginQry qry) {
        UserDTO userDTO = userInfoGatewayI.getByUsername(qry.getUsername());
        if (null == userDTO) {
            applicationContext.publishEvent(new UserLoginFailureEvent(this, qry, BizExceptionEnums.USER_NOT_EXISTS));
            throw BizExceptionFactory.of(BizExceptionEnums.USER_NOT_EXISTS);
        }
        boolean isMatches = passwordEncoder.matches(qry.getPassword(), userDTO.getPassword());
        if (!isMatches) {
            applicationContext.publishEvent(new UserLoginFailureEvent(this, qry, userDTO, BizExceptionEnums.USER_PASSWORD_ERROR));
            throw BizExceptionFactory.of(BizExceptionEnums.USER_PASSWORD_ERROR);
        }
        UserTokenDTO userTokenDTO = userTokenService.createToken(userDTO);
        return userTokenDTO.getToken();
    }
}
