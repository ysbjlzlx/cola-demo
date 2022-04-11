package com.example.demo.domain.auth.event;

import com.example.demo.base.enums.BizExceptionEnums;
import com.example.demo.domain.auth.request.UserRegisterCmd;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author where
 */
@Getter
public class UserRegisterFailureEvent extends ApplicationEvent {
    private final UserRegisterCmd cmd;
    private final BizExceptionEnums bizExceptionEnums;

    public UserRegisterFailureEvent(Object source, UserRegisterCmd cmd) {
        super(source);
        this.cmd = cmd;
        this.bizExceptionEnums = null;
    }

    public UserRegisterFailureEvent(Object source, UserRegisterCmd cmd, BizExceptionEnums enums) {
        super(source);
        this.cmd = cmd;
        this.bizExceptionEnums = enums;
    }
}
