package com.mousika.code.bean;

/**
 * 自定义对象用于像页面Column List 传送数据
 * 
 * @author xiaojf 294825811@qq.com
 */
public class CustomColumnBean {
    private String remarks;
    private String sqlName;
    private String javaType;
    private String jdbcSqlTypeName;
    private boolean pk;
    private boolean nullable;
    private boolean unique;

    public CustomColumnBean() {
        super();
    }

    public CustomColumnBean(String remarks, String sqlName, String javaType, String jdbcSqlTypeName, boolean pk, boolean nullable, boolean unique) {
        super();
        this.remarks = remarks;
        this.sqlName = sqlName;
        this.javaType = javaType;
        this.jdbcSqlTypeName = jdbcSqlTypeName;
        this.pk = pk;
        this.nullable = nullable;
        this.unique = unique;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSqlName() {
        return sqlName;
    }

    public void setSqlName(String sqlName) {
        this.sqlName = sqlName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJdbcSqlTypeName() {
        return jdbcSqlTypeName;
    }

    public void setJdbcSqlTypeName(String jdbcSqlTypeName) {
        this.jdbcSqlTypeName = jdbcSqlTypeName;
    }

    public boolean isPk() {
        return pk;
    }

    public void setPk(boolean pk) {
        this.pk = pk;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    @Override
    public String toString() {
        return "CustomColumnBean [remarks=" + remarks + ", sqlName=" + sqlName + ", javaType=" + javaType + ", jdbcSqlTypeName=" + jdbcSqlTypeName + ", pk=" + pk + ", nullable=" + nullable
                + ", unique=" + unique + "]";
    }
    
    

}
