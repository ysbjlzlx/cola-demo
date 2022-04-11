package com.example.demo.base.factories;

import com.alibaba.cola.exception.BizException;
import com.example.demo.base.enums.BizExceptionEnums;

/**
 * @author where
 */
public class BizExceptionFactory {
    public static BizException of(BizExceptionEnums bizExceptionEnums) {
        return new BizException(bizExceptionEnums.getErrCode(),
                bizExceptionEnums.getErrMessage());
    }
}
