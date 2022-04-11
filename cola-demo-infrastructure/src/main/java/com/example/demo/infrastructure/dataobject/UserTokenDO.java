package com.example.demo.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "user_token")
public class UserTokenDO extends BaseDO {
    private Long userId;
    private String token;
    private LocalDateTime expiredAt;
}
