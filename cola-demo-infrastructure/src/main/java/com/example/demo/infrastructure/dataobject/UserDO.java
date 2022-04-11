package com.example.demo.infrastructure.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author where
 */
@Data
@TableName(value = "user")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
