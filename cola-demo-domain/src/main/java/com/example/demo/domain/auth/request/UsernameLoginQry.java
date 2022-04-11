package com.example.demo.domain.auth.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.management.Query;

/**
 * @author where
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UsernameLoginQry extends Query {
    private String username;
    private String password;
}
