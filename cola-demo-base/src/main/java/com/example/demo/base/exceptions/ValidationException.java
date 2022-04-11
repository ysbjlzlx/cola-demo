package com.example.demo.base.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

import java.util.*;

/**
 * @author Where.LIU
 * @since 2022/4/11
 */
public class ValidationException extends javax.validation.ValidationException {
    @Getter
    @Setter
    private Map<String, List<String>> errors;

    public ValidationException() {
        this.errors = new HashMap<>();
    }

    public void addError(String field, String message) {
        Assert.isTrue(Objects.nonNull(field), "field is required");
        Assert.isTrue(Objects.nonNull(message), "message is required");
        List<String> messages = this.errors.getOrDefault(field, new ArrayList<>());
        messages.add(message);
        this.errors.put(field, messages);
    }

    /**
     * 处理 GET 请求中 使用 @Valid 验证路径中请求实体校验失败后抛出的异常
     *
     * @param e BindException
     * @return ValidationException
     */
    public static ValidationException of(BindException e) {
        ValidationException exception = new ValidationException();
        for (FieldError error : e.getFieldErrors()) {
            exception.addError(error.getField(), error.getDefaultMessage());
        }

        return exception;
    }
}
