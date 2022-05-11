package com.example.demo;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Where.LIU
 * @since 2022/5/11
 */
@Testable
@Slf4j
public class StreamTests {
    @Test
    public void peek() {
        User one = User.builder().username("a").password("a-p").build();
        User two = User.builder().username("b").password("b-p").build();
        List<User> userList = Arrays.asList(one, two);

        List<User> modifiedUserList = userList.stream().peek(user -> {
            user.setUsername("modified");
        }).collect(Collectors.toList());

        log.info("{}", userList);
        log.info("{}", modifiedUserList);
    }

    @Test
    public void map() {
        User one = User.builder().username("a").password("a-p").build();
        User two = User.builder().username("b").password("b-p").build();
        List<User> userList = Arrays.asList(one, two);

        List<User> modifiedUserList = userList.stream().map(user -> {
            user.setUsername("modified");
            return user;
        }).collect(Collectors.toList());

        log.info("{}", userList);
        log.info("{}", modifiedUserList);
    }

    @Data
    @Builder
    public static class User {
        private String username;
        private String password;
    }
}
