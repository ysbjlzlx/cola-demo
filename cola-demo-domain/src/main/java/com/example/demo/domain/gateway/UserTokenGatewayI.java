package com.example.demo.domain.gateway;

import com.example.demo.domain.dto.UserTokenDTO;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author where
 */
@Component
public interface UserTokenGatewayI {
    void createToken(UserTokenDTO userTokenDTO);

    @Nullable
    UserTokenDTO getByToken(String token);
}
