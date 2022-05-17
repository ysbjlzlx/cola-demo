package com.example.demo.domain.security;

import com.example.demo.domain.security.login.LoginAuthenticationFilter;
import com.example.demo.domain.security.login.LoginAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public LoginAuthenticationFilter loginAuthenticationFilter() {
        return new LoginAuthenticationFilter();
    }

    @Bean
    public LoginAuthenticationProvider loginAuthenticationProvider() {
        return new LoginAuthenticationProvider();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilter(loginAuthenticationFilter());

        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(loginAuthenticationProvider());
    }
}
