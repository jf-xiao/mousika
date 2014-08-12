package com.mousika.security.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "us_user_role", catalog = "mousika")
public class UsUserRole implements java.io.Serializable {

    private String userRoleId;              //主键
    private String userId;                  //用户主键
    private String roleId;                  //角色主键

    public UsUserRole() {
    }

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "USER_ROLE_ID", unique = true, nullable = false, length = 64)
    public String getUserRoleId() {
        return this.userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Column(name = "USER_ID", length = 64)
    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "ROLE_ID", length = 64)
    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}