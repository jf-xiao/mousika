package com.mousika.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * 角色权限
 * @author xiaojf
 *
 */
@Entity
@Table(name = "us_role_auth", catalog = "mousika")
public class UsRoleAuth implements java.io.Serializable {

    private String roleAuthId;              //主键
    private String roleId;                  //角色主键
    private String authId;                  //权限主键

    public UsRoleAuth() {
    }

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ROLE_AUTH_ID", unique = true, nullable = false, length = 64)
    public String getRoleAuthId() {
        return this.roleAuthId;
    }

    public void setRoleAuthId(String roleAuthId) {
        this.roleAuthId = roleAuthId;
    }

    @Column(name = "ROLE_ID", length = 64)
    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Column(name = "AUTH_ID", length = 64)
    public String getAuthId() {
        return this.authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

}