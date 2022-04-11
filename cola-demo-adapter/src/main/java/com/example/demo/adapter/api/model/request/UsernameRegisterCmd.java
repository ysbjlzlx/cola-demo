package com.example.demo.adapter.api.model.request;

import com.alibaba.cola.dto.Command;
import com.example.demo.base.annotation.validator.Equals;
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
@Equals(properties = {"password", "passwordConfirmation"})
public class UsernameRegisterCmd extends Command {
    @NotBlank
    @Size(min = 3)
    private String username;
    @NotBlank
    @Size(min = 6)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private String password;
    @NotBlank
    @Size(min = 6)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private String passwordConfirmation;
}
