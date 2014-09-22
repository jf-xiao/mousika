package com.mousika.tool.bean;

public class PrimaryKeyInfo {
    private String tableCat ;//表类别（可为 null） 
    private String tableSchem;//表模式（可为 null）
    private String tableName ;//表名称
    private String columnName;//列名称 
    private short keySeq;//主键中的序列号（值 1 表示主键中的第一列，值 2 表示主键中的第二列）。 
    private String pkName;//主键的名称（可为 null） 
    public PrimaryKeyInfo() {
        super();
    }
    public PrimaryKeyInfo(String tableCat, String tableSchem, String tableName, String columnName, short keySeq,
            String pkName) {
        super();
        this.tableCat = tableCat;
        this.tableSchem = tableSchem;
        this.tableName = tableName;
        this.columnName = columnName;
        this.keySeq = keySeq;
        this.pkName = pkName;
    }
    @Override
    public String toString() {
        return "PrimaryKeyInfo [tableCat=" + tableCat + ", tableSchem=" + tableSchem + ", tableName=" + tableName
                + ", columnName=" + columnName + ", keySeq=" + keySeq + ", pkName=" + pkName + "]";
    }
    public String getTableCat() {
        return tableCat;
    }
    public void setTableCat(String tableCat) {
        this.tableCat = tableCat;
    }
    public String getTableSchem() {
        return tableSchem;
    }
    public void setTableSchem(String tableSchem) {
        this.tableSchem = tableSchem;
    }
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    public String getColumnName() {
        return columnName;
    }
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public short getKeySeq() {
        return keySeq;
    }
    public void setKeySeq(short keySeq) {
        this.keySeq = keySeq;
    }
    public String getPkName() {
        return pkName;
    }
    public void setPkName(String pkName) {
        this.pkName = pkName;
    }
}
