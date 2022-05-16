package com.example.demo.domain.user.listener;

import com.example.demo.domain.user.event.CreateUserEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Where.LIU
 * @since 2022/5/16
 */
@Component
@Slf4j
public class CreateUserListener implements ApplicationListener<CreateUserEvent> {
    @Async
    @Override
    public void onApplicationEvent(CreateUserEvent event) {
        log.info("{}", event.getCreateUserEntity());
    }
}
