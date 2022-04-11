package com.example.demo.adapter.api.convertor;

import com.example.demo.adapter.api.model.request.UsernameLoginCmd;
import com.example.demo.domain.auth.request.UsernameLoginQry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsernameLoginQryConvertor {
    UsernameLoginQry of(UsernameLoginCmd source);
}
