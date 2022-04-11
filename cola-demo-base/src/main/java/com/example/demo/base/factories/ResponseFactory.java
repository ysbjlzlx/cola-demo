package com.example.demo.base.factories;

import com.alibaba.cola.dto.Response;
import com.example.demo.base.enums.BizExceptionEnums;

/**
 * @author where
 */
public class ResponseFactory {
    public static Response buildFailure(BizExceptionEnums bizExceptionEnums) {
        return Response.buildFailure(bizExceptionEnums.getErrCode(),
                bizExceptionEnums.getErrMessage());
    }
}
