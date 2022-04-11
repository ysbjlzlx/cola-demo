package com.example.demo.infrastructure.convertor;

import com.example.demo.domain.dto.UserTokenDTO;
import com.example.demo.infrastructure.dataobject.UserTokenDO;
import org.mapstruct.Mapper;

/**
 * @author where
 */
@Mapper(componentModel = "spring")
public interface UserTokenConvertor {
    UserTokenDO of(UserTokenDTO source);

    UserTokenDTO of(UserTokenDO userTokenPO);
}
