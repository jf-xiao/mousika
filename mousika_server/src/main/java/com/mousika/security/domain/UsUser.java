package com.mousika.security.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.junit.Ignore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
/**
 * 用户
 * @author xiaojf
 *
 */
@Entity
@Table(name = "us_user", catalog = "mousika")
public class UsUser implements java.io.Serializable , UserDetails{

    private String userId;              // 用户ID
    private String username;            // 登陆名
    private String password;            // 密码
    private String salt;                // 盐值
    private String enable;             // 是否可用
    private String nickname;            // 昵称
    private String email;               // 邮箱
    private String name;                // 名称
    private String address;             // 地址
    
    //默认字段
    private Date createTime;           //创建时间
    private Date updateTime;           //修改时间
    private int version;               //版本号
    private String logDel;             //逻辑删除
    private String remarks;            //备注
    
    private Collection<? extends GrantedAuthority> authorities; // 权限资源

    public UsUser() {
    }
    
    public UsUser(String userId, String username, String password, String salt,
            String enable, String nickname, String email, String name,
            String address) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.enable = enable;
        this.nickname = nickname;
        this.email = email;
        this.name = name;
        this.address = address;
    }
    
    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "USER_ID", unique = true, nullable = false, length = 64)
    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Version
    @Column(name = "VERSION")
    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name = "USERNAME", length = 36)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD", length = 36)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "ENABLE", length = 16)
    public String getEnable() {
        return this.enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
    }

    @Column(name = "SALT", length = 36)
    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Column(name = "NICKNAME", length = 36)
    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Column(name = "NAME", length = 36)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "EMAIL", length = 36)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "ADDRESS", length = 64)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "CREATE_TIME", length = 19)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "UPDATE_TIME", length = 19)
    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Column(name = "REMARKS", length = 254)
    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Column(name = "LOG_DEL", length = 16)
    public String getLogDel() {
        return this.logDel;
    }

    public void setLogDel(String logDel) {
        this.logDel = logDel;
    }
   
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return Boolean.parseBoolean(this.enable);
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return Boolean.parseBoolean(this.enable);
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return Boolean.parseBoolean(this.enable);
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return Boolean.parseBoolean(this.enable);
    }

}