package com.example.demo.advice;

import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.base.exceptions.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;

/**
 * @author Where.LIU
 * @since 2022/4/11
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public SingleResponse<Map<String, List<String>>> validationExceptionHandler(ValidationException e) {
        SingleResponse<Map<String, List<String>>> response = SingleResponse.of(e.getErrors());
        response.setErrCode("A0422");
        response.setErrMessage("Invalid input.");
        response.setSuccess(false);
        return response;
    }

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
     *
     * @param e BindException
     */
    @ExceptionHandler(BindException.class)
    public void bindExceptionHandler(BindException e) throws ValidationException {
        throw ValidationException.of(e);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
     *
     * @param e ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationExceptionHandler(ConstraintViolationException e) {
        throw ValidationException.of(e);
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常
     *
     * @param e MethodArgumentNotValidException
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    public void methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        throw ValidationException.of(e);
    }

    /**
     * 处理请求参数格式错误 @RequestBody JSON 解析错误时抛出
     *
     * @param e HttpMessageNotReadableException
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        throw ValidationException.of(e);
    }
}
