package com.example.demo.base.helper;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.common.enums.BizExceptionEnums;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author where
 */
public class ResponseHelper {
    public static Response buildFailure(BizExceptionEnums bizExceptionEnums) {
        return Response.buildFailure(bizExceptionEnums.getErrCode(),
                bizExceptionEnums.getErrMessage());
    }

    public static SingleResponse<Map<String, List<String>>> buildValidationFailure() {
        SingleResponse<Map<String, List<String>>> response = new SingleResponse<>();
        response.setSuccess(false);
        response.setErrCode(BizExceptionEnums.USER_INVALID_INPUT.getErrCode());
        response.setErrMessage(BizExceptionEnums.USER_INVALID_INPUT.getErrMessage());
        response.setData(Collections.emptyMap());
        return response;
    }
}
