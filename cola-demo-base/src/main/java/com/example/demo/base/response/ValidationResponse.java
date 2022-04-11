package com.example.demo.base.response;

import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.base.constants.Constants;
import com.example.demo.common.enums.BizExceptionEnums;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author where.liu
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ValidationResponse extends SingleResponse<Map<String, List<String>>> {
    @JsonInclude
    private Map<String, List<String>> data;

    public static ValidationResponse buildFailure() {
        return buildFailure(BizExceptionEnums.USER_INVALID_INPUT.getErrCode(),
                BizExceptionEnums.USERNAME_IS_EXISTS.getErrMessage());
    }

    public static ValidationResponse buildFailure(String errCode, String errMessage) {
        ValidationResponse response = new ValidationResponse();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        response.setData(new HashMap<>(Constants.DEFAULT_INITIAL_CAPACITY));
        return response;
    }

    public static ValidationResponse of(Map<String, List<String>> data) {
        ValidationResponse validationResponse = buildFailure();
        validationResponse.setData(data);
        return validationResponse;
    }

    public void addError(String field, String message) {
        if (null == data) {
            data = new HashMap<>(Constants.DEFAULT_INITIAL_CAPACITY);
        }
        List<String> messages = data.getOrDefault(field, new ArrayList<>());
        messages.add(message);
        data.put(field, messages);
    }
}
