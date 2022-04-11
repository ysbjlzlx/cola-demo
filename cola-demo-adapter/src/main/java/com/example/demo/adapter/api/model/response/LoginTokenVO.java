package com.example.demo.adapter.api.model.response;

import com.alibaba.cola.dto.DTO;
import lombok.*;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginTokenVO extends DTO {
    private String token;
}
