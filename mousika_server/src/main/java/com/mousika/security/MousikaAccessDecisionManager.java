package com.mousika.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 访问决策器
 * 
 * @author xiaojf
 * 
 */
public class MousikaAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object,Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        // 该访问未被限制，直接放行
        if (configAttributes == null || configAttributes.size() <= 0) {
            return;
        }
        // 用户所拥有的权限/角色
        Collection<? extends GrantedAuthority> userAuthorities = authentication.getAuthorities();

        for (ConfigAttribute attribute : configAttributes) {
            // 当前访问需要的权限/角色
            String needAuthority = attribute.getAttribute();

            for (GrantedAuthority authority : userAuthorities) {
                if (authority.getAuthority().equals(needAuthority)) {
                    return;// 用户拥有访问权限
                }
            }
            // 没有访问权限
            throw new AccessDeniedException(" 没有权限访问！ ");
        }

    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

}
