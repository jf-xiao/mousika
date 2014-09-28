package com.mousika.tool.bean;

public class JdbcConfigInfo {
    private String driverClass;
    private String url;
    private String username;
    private String password;
    private String type;
    
    public JdbcConfigInfo() {
        super();
    }
    
    public JdbcConfigInfo(String driverClass, String url, String username, String password) {
        super();
        this.driverClass = driverClass;
        this.url = url;
        this.username = username;
        this.password = password;
    }
    
    

    public JdbcConfigInfo(String driverClass, String url, String username, String password, String type) {
        super();
        this.driverClass = driverClass;
        this.url = url;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    @Override
    public String toString() {
        return "JdbcConfigInfo [driverClass=" + driverClass + ", url=" + url + ", username=" + username + ", password="
                + password + "]";
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
