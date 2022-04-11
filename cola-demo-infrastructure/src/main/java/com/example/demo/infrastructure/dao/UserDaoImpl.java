package com.example.demo.infrastructure.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.base.contants.MybatisConstants;
import com.example.demo.infrastructure.dataobject.UserDO;
import com.example.demo.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public class UserDaoImpl extends ServiceImpl<UserMapper, UserDO> implements IService<UserDO> {
    public UserDO getByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(UserDO::getUsername, username);
        queryWrapper.last(MybatisConstants.LIMIT_ONE);
        return baseMapper.selectOne(queryWrapper);
    }
}
