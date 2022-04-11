package com.example.demo.domain;

import com.alibaba.cola.dto.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends DTO {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
}
