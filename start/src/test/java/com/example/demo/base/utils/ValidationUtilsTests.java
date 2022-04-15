package com.example.demo.base.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

/**
 * @author Where.LIU
 * @since 2022/4/15
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class ValidationUtilsTests {

    @Test
    public void size() {
        User user = new User();
        user.setUsername("a");
        user.setPassword("p");

        Map<String, List<String>> errors = ValidationUtils.validate(user);

        log.info("{}", errors);
        Assertions.assertEquals(2, errors.size());
    }

    @Data
    public static class User {
        @Length(min = 3, max = 16)
        private String username;
        @Length(min = 6)
        private String password;
        @Size(max = 3)
        private List<String> pets;

    }
}
