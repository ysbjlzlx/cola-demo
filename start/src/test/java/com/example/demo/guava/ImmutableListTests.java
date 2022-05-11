package com.example.demo.guava;

import com.example.demo.StreamTests;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Where.LIU
 * @since 2022/5/11
 */
@Testable
@Slf4j
public class ImmutableListTests {
    @Test
    public void t() {
        StreamTests.User one = StreamTests.User.builder().username("a").password("a-p").build();
        StreamTests.User two = StreamTests.User.builder().username("b").password("b-p").build();
        ImmutableList<StreamTests.User> userImmutableList = ImmutableList.of(one, two);

        List<StreamTests.User> userList = userImmutableList.stream().peek(user -> {
            user.setUsername("modified");
        }).collect(Collectors.toList());

        log.info("{}", userImmutableList);
        log.info("{}", userList);
    }
}
