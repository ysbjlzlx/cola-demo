package com.example.demo.domain.gateway;

import com.example.demo.domain.UserDTO;
import com.example.demo.domain.auth.request.UserRegisterCmd;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public interface UserInfoGatewayI {
    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 存在 = true
     */
    boolean isExistsByUsername(String username);

    /**
     * 保存注册用户
     *
     * @param cmd 注册信息
     * @return 返回注册成功的 id
     */
    Long createUser(UserRegisterCmd cmd);

    /**
     * 根据用户名获取用户
     *
     * @param username 用户名
     * @return 用户
     */
    @Nullable
    UserDTO getByUsername(String username);

    UserDTO getById(Long userId);
}
