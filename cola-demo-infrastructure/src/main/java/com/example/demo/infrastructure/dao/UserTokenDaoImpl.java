package com.example.demo.infrastructure.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.base.contants.MybatisContants;
import com.example.demo.infrastructure.dataobject.UserTokenDO;
import com.example.demo.infrastructure.mapper.UserTokenMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * @author where
 */
@Service
public class UserTokenDaoImpl extends ServiceImpl<UserTokenMapper, UserTokenDO> implements IService<UserTokenDO> {
    @Nullable
    public UserTokenDO getByToken(String token) {
        LambdaQueryWrapper<UserTokenDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserTokenDO::getToken, token);
        queryWrapper.last(MybatisContants.LIMIT_ONE);
        return baseMapper.selectOne(queryWrapper);
    }
}
