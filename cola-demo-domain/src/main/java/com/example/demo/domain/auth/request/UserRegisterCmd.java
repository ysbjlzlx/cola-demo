package com.example.demo.domain.auth.request;

import com.alibaba.cola.dto.Command;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserRegisterCmd extends Command {
    @Size(min = 3)
    @NotBlank
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    @Size(min = 6)
    @NotBlank
    private String password;
}
