package com.mousika.tool.bean;

/**
 * 数据库
 * @author xiaojf 294825811@qq.com
 */
public class DatabaseInfo {
    private String key;             //数据库标识
    private String driverClass;     //驱动类
    private String url;             //链接url
    private String username;        //用户名
    private String password;        //密码
    private String productName;     //产品名称

    public DatabaseInfo() {
        super();
    }

    public DatabaseInfo(String key, String driverClass, String url, String username, String password) {
        super();
        this.key = key;
        this.driverClass = driverClass;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public DatabaseInfo(String key, String driverClass, String url, String username, String password, String productName) {
        super();
        this.key = key;
        this.driverClass = driverClass;
        this.url = url;
        this.username = username;
        this.password = password;
        this.productName = productName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "DatabaseInfo [key=" + key + ", driverClass=" + driverClass + ", url=" + url + ", username=" + username + ", password=" + password + ", productName=" + productName + "]";
    }

}
