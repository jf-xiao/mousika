package com.mousika.security;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mousika.common.util.JdbcUtil;
import com.mousika.security.domain.UsRole;
import com.mousika.security.domain.UsUser;
/**
 * @author xiaojf 294825811@qq.com
 */
public class MousikaUserDetailsService implements UserDetailsService {
    
    /**
     * 根据用户名加载用户信息
     * @author xiaojf
     * @return 用户信息
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsUser user = this.loadUserInfo(username);
        //用户不存在
        if (user == null) {
            throw new UsernameNotFoundException("username : "+username + "is not found.");
        }
        //加载用户角色信息
        List<UsRole> roles = this.loadRoleWithUsername(username);
        //加载用户所具有权限
        Collection<? extends GrantedAuthority> authorities = obtionGrantedAuthorities(roles);
        user.setAuthorities(authorities);
        
        return user;
    }

    /**
     * 根据用户名获取用户所拥有的可用的权限/角色
     * 
     * @param username 登录名
     * @return  用户所具有的所有角色
     */
    private List<UsRole> loadRoleWithUsername(String username) {
        List<UsRole> roles = new ArrayList<UsRole>();
        ResultSet rs = null;
        JdbcUtil sql = new JdbcUtil();
        //获取当前用户可用的角色
        rs = sql.executeQuery("SELECT * FROM us_role r,us_user u , us_user_role l WHERE r.role_id = l.role_id AND r.enable != '0' AND r.enable != FALSE AND r.enable IS NOT NULL AND u.user_id = l.user_id AND u.username = '"
                + username + "'");
        try {
            while (rs.next()) {
                String roleId = rs.getString("ROLE_ID");            //角色ID
                String name = rs.getString("NAME");                 //名称
                String enable = rs.getBoolean("ENABLE")+"";           //是否可用
                UsRole role = new UsRole(roleId, name, enable);
                roles.add(role);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return roles;
    }

    /**
     * 根据用户名获取用户详细信息
     * 
     * @param username
     * @return
     */
    private UsUser loadUserInfo(String username) {
        ResultSet rs = null;
        UsUser user = null;
        JdbcUtil sql = new JdbcUtil();
        //获取当前登录用户的基本信息
        rs = sql.executeQuery("select t.* from US_USER t WHERE t.enable != '0' AND t.enable != FALSE AND t.enable IS NOT NULL AND t.username = '"
                + username + "'");
        try {
            while (rs.next()) {
                String userId = rs.getString("USER_ID");            //用户ID
                String username2 = rs.getString("USERNAME");        //登录名
                String password = rs.getString("PASSWORD");         //密码
                String salt = rs.getString("SALT");                 //盐值
                String enable = rs.getBoolean("ENABLE")+"";         //是否可用
                String nickName = rs.getString("NICKNAME");         //昵称
                String email = rs.getString("EMAIL");               //邮箱
                String name = rs.getString("NAME");                 //姓名
                String address = rs.getString("ADDRESS");           //地址
                user = new UsUser(userId, username2, password, salt, enable,nickName, email, name, address);
                return user;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    /**
     * 生成GrantedAuthority对象
     * 
     * @param roles
     * @return
     */
    private List<GrantedAuthority> obtionGrantedAuthorities(List<UsRole> roles) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        //获取当前用户所具有的权限
        for (UsRole role : roles) {
            GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(role.getName());
            authorities.add(grantedAuthority);
        }
        
        return authorities;
    }
}
