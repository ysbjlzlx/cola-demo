package com.example.demo.domain.auth.listener;

import com.example.demo.domain.auth.event.UserRegisterSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Slf4j
@Component
public class UserRegisterSuccessListener implements ApplicationListener<UserRegisterSuccessEvent> {
    @Override
    public void onApplicationEvent(UserRegisterSuccessEvent event) {
        log.info("register success {}", event.getUserRegisterCmd());
    }
}
