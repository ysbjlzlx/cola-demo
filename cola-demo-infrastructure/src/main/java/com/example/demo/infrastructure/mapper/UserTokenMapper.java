package com.example.demo.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.infrastructure.dataobject.UserTokenDO;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public interface UserTokenMapper extends BaseMapper<UserTokenDO> {
}
