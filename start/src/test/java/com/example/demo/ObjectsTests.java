package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.Objects;

/**
 * @author Where.LIU
 * @since 2022/4/14
 */
@Testable
@Slf4j
public class ObjectsTests {
    @Test
    public void equals() {
        log.info("{}", Objects.equals(1, null));
        log.info("{}", Objects.equals(null, 1));
    }
}
