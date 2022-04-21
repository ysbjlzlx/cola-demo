package com.example.demo.base.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author Where.LIU
 * @since 2022/4/21
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class DateTimeUtilsTests {

    @Test
    public void defaultDatetime() {
        log.info(DateTimeUtils.datetime(new Date()));
    }
}
