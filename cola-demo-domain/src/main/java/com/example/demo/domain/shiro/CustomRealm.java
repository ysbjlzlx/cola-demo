package com.example.demo.domain.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author Where.LIU
 * @since 2022/5/17
 */
public class CustomRealm extends AuthorizingRealm {
    /**
     * 获取授权信息
     *
     * @param principalCollection the primary identifying principals of the AuthorizationInfo that should be retrieved.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(null);
        return info;
    }

    /**
     * 获取用户信息
     *
     * @param authenticationToken token
     * @return 用户信息
     * @throws AuthenticationException 未找到用户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        if (StringUtils.isBlank(token)) {
            throw new AuthenticationException("Token is empty.");
        }
        return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(), token, getName());
    }

    /**
     * 当前 realm 支持处理的 token 类型
     *
     * @param token the token being submitted for authentication.
     * @return true 支持处理
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }
}
