package com.example.demo.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author where
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
@Getter
@AllArgsConstructor
public enum BizExceptionEnums {
    /**
     * 正确执行后的返回
     */
    OK("00000", "一切 OK"),
    /**
     * 一级宏观错误码
     */
    USER_CLIENT_ERROR("A0001", "用户端错误"),
    /**
     * 二级宏观错误码
     */
    USER_REGISTER_FAILURE("A0100", "用户注册错误"),
    USER_UNCHECKED_PRIVACY_TERM("A0101", "用户未同意隐私协议"),
    USERNAME_IS_EXISTS("A0111", "用户名已存在"),
    /**
     * 二级宏观错误码
     */
    USER_LOGIN_FAILURE("A0200", "用户登陆异常"),
    USER_NOT_EXISTS("A0201", "用户账户不存在"),
    USER_PASSWORD_ERROR("A0210", "用户密码错误"),
    USER_INVALID_TOKEN("A0220", "用户身份校验失败"),
    USER_INVALID_INPUT("A0430", "用户输入内容非法"),
    /**
     * 一级宏观错误码
     */
    SYSTEM_EXECUTE_ERROR("B0001", "系统执行出错"),
    ;
    /**
     * 错误码
     */
    private final String errCode;
    /**
     * 中文描述
     */
    private final String errMessage;
}



