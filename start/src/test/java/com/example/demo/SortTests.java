package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import java.util.*;

/**
 * @author Where.LIU
 * @since 2022/5/5
 */
@Testable
@Slf4j
public class SortTests {
    @Test
    public void mapByKey() {
        Map<String, String> source = new HashMap<>();
        source.put("c", "c");
        source.put("d", "d");
        source.put("a", "a");
        source.put("b", "b");
        source.put("0", "0");
        Map<String, String> sorted = new TreeMap<>(Comparator.reverseOrder());
        sorted.putAll(source);

        log.info("====== source ======");
        source.forEach((key, value) -> log.info("{} : {}", key, value));
        log.info("====== sorted ======");
        sorted.forEach((key, value) -> log.info("{} : {}", key, value));
    }

    @Test
    public void mayByValue() {
        Map<String, String> source = new HashMap<>();
        source.put("c", "c");
        source.put("d", "d");
        source.put("a", "a");
        source.put("b", "b");
        source.put("0", "0");

        Comparator<Map.Entry<String, String>> comparator = new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        };

        List<Map.Entry<String, String>> sortedList = new ArrayList<>(source.entrySet());
        sortedList.sort(comparator);

        Map<String, String> sorted = new LinkedHashMap<>();
        sortedList.forEach(entry -> sorted.put(entry.getKey(), entry.getValue()));

        log.info("====== source ======");
        source.forEach((key, value) -> log.info("{} : {}", key, value));
        log.info("====== sorted ======");
        sorted.forEach((key, value) -> log.info("{} : {}", key, value));


    }


}
