package com.example.demo.base.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 仿照 FastJSON 的接口，生成 Jackson 的静态调用方法
 *
 * @author where
 */
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@Slf4j
public class JSONUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ISO_LOCAL_TIME));
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        MAPPER.registerModule(new SimpleModule());
        MAPPER.registerModule(javaTimeModule);
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * 将对象转为 JSON 字符串
     *
     * @param object 待转化的对象
     * @return 字符串
     */
    @Nullable
    @SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
    public static String toJSONString(Object object) {
        try {
            return MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("toJSONString error", e);
        }
        return null;
    }

    /**
     * 将 JSON 字符串解析为指定对象
     *
     * @param json  JSON 字符串
     * @param clazz 目标类
     * @param <T>   目标类
     * @return 结果
     */
    @Nullable
    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.error("parseObject error", e);
        }
        return null;
    }

    /**
     * 将 JSON 字符串转为数组结果对象
     *
     * @param json  JSON 字符串
     * @param clazz 目标类
     * @param <T>   目标类
     * @return 结果
     */
    @Nullable
    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        try {
            JavaType type = MAPPER.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            return MAPPER.readValue(json, type);
        } catch (JsonProcessingException e) {
            log.error("parseArray error", e);
        }
        return null;
    }
}