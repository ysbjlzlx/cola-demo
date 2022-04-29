package com.example.demo.base.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Where.LIU
 * @since 2022/4/29
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class RandomStringUtilsTests {
    @Test
    public void randomNumeric() {
        String num = RandomStringUtils.randomNumeric(4);
        log.info("{}", num);
    }
}
