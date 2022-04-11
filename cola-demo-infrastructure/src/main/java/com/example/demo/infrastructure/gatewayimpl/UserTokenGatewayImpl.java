package com.example.demo.infrastructure.gatewayimpl;

import com.example.demo.domain.dto.UserTokenDTO;
import com.example.demo.domain.gateway.UserTokenGatewayI;
import com.example.demo.infrastructure.convertor.UserTokenConvertor;
import com.example.demo.infrastructure.dao.UserTokenDaoImpl;
import com.example.demo.infrastructure.dataobject.UserTokenDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public class UserTokenGatewayImpl implements UserTokenGatewayI {
    private final UserTokenConvertor userTokenConvertor;
    private final UserTokenDaoImpl userTokenDao;

    @Autowired
    public UserTokenGatewayImpl(UserTokenConvertor userTokenConvertor, UserTokenDaoImpl userTokenDao) {
        this.userTokenConvertor = userTokenConvertor;
        this.userTokenDao = userTokenDao;
    }

    @Override
    public void createToken(UserTokenDTO userTokenDTO) {
        UserTokenDO userTokenPO = userTokenConvertor.of(userTokenDTO);
        boolean result = userTokenDao.save(userTokenPO);
        if (result) {
            userTokenDTO.setId(userTokenPO.getId());
        }
    }

    @Override
    @Nullable
    public UserTokenDTO getByToken(String token) {
        UserTokenDO userTokenPO = userTokenDao.getByToken(token);
        return userTokenConvertor.of(userTokenPO);
    }
}
