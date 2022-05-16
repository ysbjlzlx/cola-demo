package com.example.demo.domain.user.entities;

import com.alibaba.cola.domain.Entity;
import com.example.demo.domain.user.event.CreateUserEvent;
import com.example.demo.domain.user.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @author Where.LIU
 * @since 2022/5/16
 */
@Entity
public class CreateUserEntity {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserGateway userGateway;

    @Autowired
    public CreateUserEntity(ApplicationEventPublisher applicationEventPublisher,
                            UserGateway userGateway) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.userGateway = userGateway;
    }

    public void create() {
        applicationEventPublisher.publishEvent(new CreateUserEvent(this, this));
    }
}
