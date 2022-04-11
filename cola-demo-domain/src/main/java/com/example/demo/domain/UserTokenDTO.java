package com.example.demo.domain;

import com.alibaba.cola.dto.DTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserTokenDTO extends DTO {
    private Long id;
    private Long userId;
    private String token;
    private LocalDateTime expiredAt;
}
