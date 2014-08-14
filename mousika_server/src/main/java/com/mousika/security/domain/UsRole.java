package com.mousika.security.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.annotations.GenericGenerator;

/**
 * 角色
 * @author xiaojf
 *
 */
@Entity
@Table(name = "us_role", catalog = "mousika")
public class UsRole implements java.io.Serializable {

    private String roleId;              //角色ID
    private String name;                //名称
    private String enable;              //是否可用
    
    private Date createTime;            //创建时间
    private Date updateTime;            //修改时间
    private String remarks;             //备注
    private String logDel;              //逻辑删除
    private Integer version;            //版本号

    public UsRole() {
    }
    
    public UsRole(String roleId, String name, String enable) {
        super();
        this.roleId = roleId;
        this.name = name;
        this.enable = enable;
    }

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ROLE_ID", unique = true, nullable = false, length = 64)
    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Version
    @Column(name = "VERSION")
    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Column(name = "NAME", length = 36)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ENABLE", length = 16)
    public String getEnable() {
        return this.enable;
    }

    public void setEnable(String enable) {
        this.enable = enable;
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

}