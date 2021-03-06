package com.mousika.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;

/**
 * 基于内存的密码修改
 * @author xiaojf 294825811@qq.com
 */
public class InMemoryChangePassword extends InMemoryDaoImpl implements IChangePassword {

	@Override
	public void changePassword(String username, String password) {
	    //获取当前用户
		User userDetails = (User) this.getUserMap().getUser(username);
		//修改当前用户信息
		User newUserDetails = new User(userDetails.getUsername(), userDetails.getPassword(), userDetails.isEnabled(),
				userDetails.isAccountNonExpired(), userDetails.isCredentialsNonExpired(), userDetails.isAccountNonLocked(),
				userDetails.getAuthorities());
		//将新用户信息保存更新
		this.getUserMap().addUser(newUserDetails);
	}

}
