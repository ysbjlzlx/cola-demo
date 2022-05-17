package com.example.demo.domain.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();

        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("authFilter", new AuthFilter());
        bean.setFilters(filterMap);

        HashMap<String, String> filterChain = new LinkedHashMap<>();
        filterChain.put("/api/login", "anon");
        bean.setFilterChainDefinitionMap(filterChain);

        bean.setSecurityManager(securityManager);
        return bean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(customRealm());
        return manager;
    }

    @Bean
    public Realm realm() {
        return new CustomRealm();
    }

    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }
}
