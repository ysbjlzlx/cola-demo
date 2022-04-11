package com.example.demo.domain.auth.service;

import com.example.demo.base.enums.BizExceptionEnums;
import com.example.demo.base.helper.BizExceptionHelper;
import com.example.demo.base.utils.NumberUtils;
import com.example.demo.domain.UserDTO;
import com.example.demo.domain.auth.event.UserRegisterFailureEvent;
import com.example.demo.domain.auth.event.UserRegisterSuccessEvent;
import com.example.demo.domain.auth.request.UserRegisterCmd;
import com.example.demo.domain.gateway.UserInfoGatewayI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author where
 */
@Service
@Slf4j
public class AuthService {
    private final ApplicationContext applicationContext;
    private final UserInfoGatewayI userInfoGatewayI;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(ApplicationContext applicationContext, UserInfoGatewayI userInfoGatewayI, PasswordEncoder passwordEncoder) {
        this.applicationContext = applicationContext;
        this.userInfoGatewayI = userInfoGatewayI;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 用户注册
     * TODO 应该加一个用户名纬度的并发锁
     *
     * @param cmd 用户输入
     * @return 注册结果
     */
    @Nullable
    public UserDTO register(UserRegisterCmd cmd) {
        boolean isExists = userInfoGatewayI.isExistsByUsername(cmd.getUsername());
        if (isExists) {
            applicationContext.publishEvent(new UserRegisterFailureEvent(this, cmd, BizExceptionEnums.USERNAME_IS_EXISTS));
            throw BizExceptionHelper.of(BizExceptionEnums.USERNAME_IS_EXISTS);
        }
        cmd.setPassword(passwordEncoder.encode(cmd.getPassword()));
        Long id = userInfoGatewayI.createUser(cmd);
        if (NumberUtils.isPositive(id)) {
            UserDTO userDTO = UserDTO.builder().id(id).username(cmd.getUsername()).build();
            applicationContext.publishEvent(new UserRegisterSuccessEvent(this, cmd, userDTO));
            return userDTO;
        }
        applicationContext.publishEvent(new UserRegisterFailureEvent(this, cmd));
        return null;
    }
}
