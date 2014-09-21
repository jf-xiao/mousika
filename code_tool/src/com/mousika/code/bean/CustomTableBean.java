package com.mousika.code.bean;

/**
 * 自定义对象用于像页面Table List 传送数据
 * @author xiaojf 294825811@qq.com
 */
public class CustomTableBean {
    private String tableAlias;              //表注释
    private String className;               //Class名称
    private String sqlName;                 //数据库表名
    
    public CustomTableBean() {
        super();
    }
    
    public CustomTableBean(String tableAlias, String className, String sqlName) {
        super();
        this.tableAlias = tableAlias;
        this.className = className;
        this.sqlName = sqlName;
    }


    public String getTableAlias() {
        return tableAlias;
    }
    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getSqlName() {
        return sqlName;
    }
    public void setSqlName(String sqlName) {
        this.sqlName = sqlName;
    }
    
    
}
