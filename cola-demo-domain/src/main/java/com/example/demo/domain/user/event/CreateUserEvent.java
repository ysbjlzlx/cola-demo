package com.example.demo.domain.user.event;

import com.example.demo.domain.user.entities.CreateUserEntity;
import com.example.demo.domain.user.entities.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author Where.LIU
 * @since 2022/5/16
 */
public class CreateUserEvent extends ApplicationEvent {
    @Getter
    @Setter
    private CreateUserEntity createUserEntity;

    public CreateUserEvent(Object source, CreateUserEntity createUserEntity) {
        super(source);
        this.createUserEntity = createUserEntity;
    }
}
