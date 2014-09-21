package com.mousika.tool.bean;

public class Database {
    private String key;
    private String driverClass;
    private String url;
    private String username;
    private String password;
    
    public Database() {
        super();
    }
    
    public Database(String key, String driverClass, String url, String username, String password) {
        super();
        this.key = key;
        this.driverClass = driverClass;
        this.url = url;
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Database [key=" + key + ", driverClass=" + driverClass + ", url=" + url + ", username=" + username
                + ", password=" + password + "]";
    }
}
