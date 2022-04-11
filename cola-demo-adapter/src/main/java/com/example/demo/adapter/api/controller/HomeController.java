package com.example.demo.adapter.api.controller;

import com.alibaba.cola.dto.SingleResponse;
import com.example.demo.common.AuthContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author where
 */
@RestController
@RequestMapping(value = "/home")
public class HomeController {
    @GetMapping(value = "/")
    public SingleResponse<Long> index() {
        return SingleResponse.of(AuthContext.getUserId());
    }
}
