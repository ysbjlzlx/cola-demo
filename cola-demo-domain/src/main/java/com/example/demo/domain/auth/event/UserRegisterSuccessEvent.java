package com.example.demo.domain.auth.event;

import com.example.demo.domain.auth.request.UserRegisterCmd;
import com.example.demo.domain.dto.UserDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * 用户注册成功事件
 *
 * @author where
 */
@Getter
public class UserRegisterSuccessEvent extends ApplicationEvent {
    private final UserRegisterCmd userRegisterCmd;
    private final UserDTO userDTO;

    public UserRegisterSuccessEvent(Object source, UserRegisterCmd cmd, UserDTO userDTO) {
        super(source);
        this.userRegisterCmd = cmd;
        this.userDTO = userDTO;
    }
}
