package com.example.demo.infrastructure.gatewayimpl;

import com.example.demo.domain.auth.request.UserRegisterCmd;
import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.gateway.UserInfoGatewayI;
import com.example.demo.infrastructure.convertor.UserConvertor;
import com.example.demo.infrastructure.dao.UserDaoImpl;
import com.example.demo.infrastructure.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public class UserInfoGatewayImpl implements UserInfoGatewayI {
    private final UserDaoImpl userDao;
    private final UserConvertor userConvertor;

    @Autowired
    public UserInfoGatewayImpl(UserDaoImpl userDao, UserConvertor userConvertor) {
        this.userDao = userDao;
        this.userConvertor = userConvertor;
    }

    @Override
    public boolean isExistsByUsername(String username) {
        UserDO userPO = userDao.getByUsername(username);
        return null != userPO;
    }

    @Override
    public Long createUser(UserRegisterCmd cmd) {
        UserDO userPO = userConvertor.of(cmd);
        if (userDao.save(userPO)) {
            return userPO.getId();
        }
        return null;
    }

    @Override
    public UserDTO getByUsername(String username) {
        UserDO userPO = userDao.getByUsername(username);
        return userConvertor.of(userPO);
    }

    @Override
    public UserDTO getById(Long userId) {
        UserDO userPO = userDao.getById(userId);
        return userConvertor.of(userPO);
    }
}
