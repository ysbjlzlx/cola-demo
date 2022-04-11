package com.example.demo.adapter.api.logic;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.adapter.convertor.UserRegisterCmdConvertor;
import com.example.demo.adapter.convertor.UsernameLoginQryConvertor;
import com.example.demo.adapter.model.request.UsernameLoginCmd;
import com.example.demo.adapter.model.request.UsernameRegisterCmd;
import com.example.demo.adapter.model.response.LoginTokenVO;
import com.example.demo.common.enums.BizExceptionEnums;
import com.example.demo.common.helper.ResponseHelper;
import com.example.demo.domain.auth.request.UserRegisterCmd;
import com.example.demo.domain.auth.service.AuthService;
import com.example.demo.domain.auth.service.UsernameLoginService;
import com.example.demo.domain.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author where
 */
@Service
public class AuthLogic {
    private final AuthService authService;
    private final UsernameLoginService usernameLoginService;
    private final UsernameLoginQryConvertor usernameLoginQryConvertor;
    private final UserRegisterCmdConvertor userRegisterCmdConvertor;

    @Autowired
    public AuthLogic(AuthService authService,
                     UsernameLoginService usernameLoginService,
                     UsernameLoginQryConvertor usernameLoginQryConvertor,
                     UserRegisterCmdConvertor userRegisterCmdConvertor) {
        this.authService = authService;
        this.usernameLoginService = usernameLoginService;
        this.usernameLoginQryConvertor = usernameLoginQryConvertor;
        this.userRegisterCmdConvertor = userRegisterCmdConvertor;
    }

    public Response register(UsernameRegisterCmd cmd) {
        UserRegisterCmd userRegisterCmd = userRegisterCmdConvertor.of(cmd);
        UserDTO userDTO = authService.register(userRegisterCmd);
        if (null != userDTO) {
            return Response.buildSuccess();
        }
        return ResponseHelper.buildFailure(BizExceptionEnums.USER_REGISTER_FAILURE);
    }

    public SingleResponse<LoginTokenVO> login(UsernameLoginCmd cmd) {
        String token = usernameLoginService.login(usernameLoginQryConvertor.of(cmd));

        return SingleResponse.of(LoginTokenVO.builder().token(token).build());
    }
}
