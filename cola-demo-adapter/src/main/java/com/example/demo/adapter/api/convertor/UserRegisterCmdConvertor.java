package com.example.demo.adapter.api.convertor;

import com.example.demo.adapter.model.request.UsernameRegisterCmd;
import com.example.demo.domain.auth.request.UserRegisterCmd;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRegisterCmdConvertor {
    UserRegisterCmd of(UsernameRegisterCmd source);
}
