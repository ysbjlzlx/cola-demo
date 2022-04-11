package com.example.demo.infrastructure.convertor;

import com.example.demo.domain.auth.request.UserRegisterCmd;
import com.example.demo.domain.UserDTO;
import com.example.demo.infrastructure.dataobject.UserDO;
import org.mapstruct.Mapper;

/**
 * @author where
 */
@Mapper(componentModel = "spring")
public interface UserConvertor {
    UserDTO of(UserDO source);

    UserDO of(UserRegisterCmd source);
}
