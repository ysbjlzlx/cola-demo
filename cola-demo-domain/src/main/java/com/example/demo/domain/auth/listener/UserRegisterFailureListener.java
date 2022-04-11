package com.example.demo.domain.auth.listener;

import com.example.demo.domain.auth.event.UserRegisterFailureEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRegisterFailureListener implements ApplicationListener<UserRegisterFailureEvent> {
    @Override
    public void onApplicationEvent(UserRegisterFailureEvent event) {
        log.warn("用户注册失败 {}, {}", event.getCmd(), event.getBizExceptionEnums());
    }
}
