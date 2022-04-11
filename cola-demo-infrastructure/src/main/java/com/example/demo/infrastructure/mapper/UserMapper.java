package com.example.demo.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.infrastructure.dataobject.UserDO;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public interface UserMapper extends BaseMapper<UserDO> {
}
