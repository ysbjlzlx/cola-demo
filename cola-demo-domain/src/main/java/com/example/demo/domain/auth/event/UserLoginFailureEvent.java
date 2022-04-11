package com.example.demo.domain.auth.event;

import com.example.demo.common.enums.BizExceptionEnums;
import com.example.demo.domain.auth.request.UsernameLoginQry;
import com.example.demo.domain.dto.UserDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author where
 */
@Getter
public class UserLoginFailureEvent extends ApplicationEvent {
    private final UsernameLoginQry usernameLoginQry;
    private final UserDTO userDTO;
    private final BizExceptionEnums bizExceptionEnums;

    public UserLoginFailureEvent(Object source, UsernameLoginQry qry, BizExceptionEnums enums) {
        super(source);
        this.usernameLoginQry = qry;
        this.userDTO = null;
        this.bizExceptionEnums = enums;
    }

    public UserLoginFailureEvent(Object source, UsernameLoginQry qry, UserDTO userDTO, BizExceptionEnums enums) {
        super(source);
        this.usernameLoginQry = qry;
        this.userDTO = userDTO;
        this.bizExceptionEnums = enums;
    }
}
