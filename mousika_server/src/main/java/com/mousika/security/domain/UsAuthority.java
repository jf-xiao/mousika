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
 * 权限
 * @author xiaojf
 *
 */
@Entity
@Table(name = "us_authority", catalog = "mousika")
public class UsAuthority implements java.io.Serializable {

    private String authId;          //权限ID
    private String name;            //权限名称
    private String url;             //url
    private String enable;          //是否可用
    
    private Date createTime;        //创建时间
    private Date updateTime;        //修改时间
    private String remarks;         //备注
    private String logDel;          //逻辑删除
    private Integer version;        //版本号
    
    public UsAuthority() {
        super();
    }
    
    public UsAuthority(String authId, String name, String enable, String url) {
        super();
        this.authId = authId;
        this.name = name;
        this.url = url;
        this.enable = enable;
    }

    @GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "AUTH_ID", unique = true, nullable = false, length = 64)
    public String getAuthId() {
        return this.authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
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

    @Column(name = "URL", length = 128)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
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