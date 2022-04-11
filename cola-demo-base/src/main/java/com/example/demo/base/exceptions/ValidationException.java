package com.example.demo.base.exceptions;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.Assert;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
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
        super();
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

    /**
     * 处理请求参数格式错误 @RequestParam 上 validate 失败后抛出的异常是 javax.validation.ConstraintViolationException
     *
     * @param e ConstraintViolationException
     * @return ValidationException
     */
    public static ValidationException of(ConstraintViolationException e) {
        ValidationException exception = new ValidationException();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            String field = constraintViolation.getPropertyPath().toString();
            exception.addError(field, constraintViolation.getMessage());
        }

        return exception;
    }

    /**
     * 处理请求参数格式错误 @RequestBody 上 validate 失败后抛出的异常是 MethodArgumentNotValidException 异常
     *
     * @param e MethodArgumentNotValidException
     * @return ValidationException
     */
    public static ValidationException of(MethodArgumentNotValidException e) {
        ValidationException exception = new ValidationException();
        for (FieldError error : e.getFieldErrors()) {
            exception.addError(error.getField(), error.getDefaultMessage());
        }

        return exception;
    }

    /**
     * 处理请求参数格式错误 @RequestBody JSON 解析错误时抛出
     *
     * @param e HttpMessageNotReadableException
     * @return ValidationException
     */
    public static ValidationException of(HttpMessageNotReadableException e) {
        ValidationException exception = new ValidationException();
        if (e.getCause() instanceof InvalidFormatException) {
            InvalidFormatException invalidFormatException = (InvalidFormatException) e.getCause();
            List<JsonMappingException.Reference> references = invalidFormatException.getPath();
            for (JsonMappingException.Reference reference : references) {
                exception.addError(
                        reference.getFieldName(), invalidFormatException.getOriginalMessage());
            }
        }

        return exception;
    }
}
