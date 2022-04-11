package com.example.demo.adapter.api.controller;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.adapter.api.logic.AuthLogic;
import com.example.demo.adapter.api.model.request.UsernameLoginCmd;
import com.example.demo.adapter.api.model.request.UsernameRegisterCmd;
import com.example.demo.adapter.api.model.response.LoginTokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author where
 */
@RestController
@RequestMapping(value = "/auth", name = "鉴权相关接口")
public class AuthController {
    private final AuthLogic authLogic;

    @Autowired
    public AuthController(AuthLogic authLogic) {
        this.authLogic = authLogic;
    }

    @PostMapping(value = "/register", name = "用户注册")
    public Response register(@Valid @RequestBody UsernameRegisterCmd cmd) {
        return authLogic.register(cmd);
    }

    @PostMapping(value = "/login", name = "登录")
    public SingleResponse<LoginTokenVO> login(@Valid @RequestBody UsernameLoginCmd cmd) {
        return authLogic.login(cmd);
    }
}
