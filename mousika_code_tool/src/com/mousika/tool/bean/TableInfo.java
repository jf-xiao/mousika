package com.mousika.tool.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 表信息
 * @author xiaojf 294825811@qq.com
 */
public class TableInfo {
    private String tableCat;                                                // 表类别（可为 null）
    private String tableSchem;                                              // 表模式（可为 null）
    private String tableName;                                               // 表名称
    private String tableType;                                               // 表类型。典型的类型是 "TABLE"、"VIEW"、"SYSTEM TABLE"、"GLOBAL TEMPORARY"、"LOCAL TEMPORARY"、"ALIAS" 和 "SYNONYM"。
    private String remarks;                                                 // 表的解释性注释
    private String typeCat;                                                 // 类型的类别（可为 null）
    private String typeSchem;                                               // 类型模式（可为 null）
    private String typeName;                                                // 类型名称（可为 null）
    private String selfReferencingColName;                                  // 有类型表的指定 "identifier" 列的名称（可为 null）
    private String refGeneration;                                           // 指定在 SELF_REFERENCING_COL_NAME 中创建值的方式。这些值为 "SYSTEM"、"USER" 和 "DERIVED"。（可能为 null）

    private List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();     // 表的列信息
    private boolean isEnable = false;                                       // 是否创建

    public TableInfo() {
        super();
    }

    public TableInfo(String tableCat, String tableSchem, String tableName, String tableType, String remarks, String typeCat, String typeSchem, String typeName, String selfReferencingColName,
            String refGeneration) {
        super();
        this.tableCat = tableCat;
        this.tableSchem = tableSchem;
        this.tableName = tableName;
        this.tableType = tableType;
        this.remarks = remarks;
        this.typeCat = typeCat;
        this.typeSchem = typeSchem;
        this.typeName = typeName;
        this.selfReferencingColName = selfReferencingColName;
        this.refGeneration = refGeneration;
    }

    @Override
    public String toString() {
        return "TableInfo [tableCat=" + tableCat + ", tableSchem=" + tableSchem + ", tableName=" + tableName + ", tableType=" + tableType + ", remarks=" + remarks + ", typeCat=" + typeCat
                + ", typeSchem=" + typeSchem + ", typeName=" + typeName + ", selfReferencingColName=" + selfReferencingColName + ", refGeneration=" + refGeneration + ", columnInfos=" + columnInfos
                + ", isEnable=" + isEnable + "]";
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

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTypeCat() {
        return typeCat;
    }

    public void setTypeCat(String typeCat) {
        this.typeCat = typeCat;
    }

    public String getTypeSchem() {
        return typeSchem;
    }

    public void setTypeSchem(String typeSchem) {
        this.typeSchem = typeSchem;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSelfReferencingColName() {
        return selfReferencingColName;
    }

    public void setSelfReferencingColName(String selfReferencingColName) {
        this.selfReferencingColName = selfReferencingColName;
    }

    public String getRefGeneration() {
        return refGeneration;
    }

    public void setRefGeneration(String refGeneration) {
        this.refGeneration = refGeneration;
    }

    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }

    public void setColumnInfos(List<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

}
