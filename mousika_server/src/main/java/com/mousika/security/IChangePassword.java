package com.mousika.security;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 修改密码接口
 * @author xiaojf
 *
 */
public interface IChangePassword extends UserDetailsService {
    /**
     * 修改密码
     * @param username  用户名
     * @param password  密码
     */
	public void changePassword(String username,String password);
}
