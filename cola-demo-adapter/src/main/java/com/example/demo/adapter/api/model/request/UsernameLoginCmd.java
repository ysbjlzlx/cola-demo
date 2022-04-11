package com.example.demo.adapter.api.model.request;

import com.alibaba.cola.dto.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(callSuper = true)
@Data
public class UsernameLoginCmd extends Command {
    @NotBlank
    @Size(min = 3)
    private String username;
    @NotBlank
    @Size(min = 6)
    private String password;
}
