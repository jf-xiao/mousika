package com.mousika.tool.bean;

import com.mousika.tool.util.CamelCaseUtil;
/**
 * 字段
 * @author xiaojf 294825811@qq.com
 */
public class ColumnInfo {
    private String tableCat;                //表类别（可为 null
    private String tableSchem;              //表模式（可为 null）
    private String tableName;               //表名称 
    private String columnName;              //列名称
    private int dataType;                   //来自 java.sql.Types 的 SQL 类型
    private String typeName;                //数据源依赖的类型名称，对于 UDT，该类型名称是完全限定的 
    private int columnSize;                 //列的大小
    private String bufferLength;            //未被使用
    private int decimalDigits;              //小数部分的位数。对于 DECIMAL_DIGITS 不适用的数据类型，则返回 Null。 
    private String numPrecRadix;            //基数（通常为 10 或 2）
    private int nullable;                   //是否允许使用 NULL。 columnNoNulls / 可能不允许使用 NULL 值 columnNullable / 明确允许使用 NULL 值 columnNullableUnknown /不知道是否可使用 null 
    private String remarks;                 //描述列的注释（可为 null） 
    private String columnDef;               //该列的默认值，当值在单引号内时应被解释为一个字符串（可为 null） 
    private int sqlDataType;                //未使用
    private int sqlDatetimeSub;             //未使用 
    private int charOctetLength;            // 对于 char 类型，该长度是列中的最大字节数 
    private int ordinalPosition;            //表中的列的索引（从 1 开始） 
    private String isNullable;              //ISO 规则用于确定列是否包括 null。 YES --- 如果参数可以包括 NULL /NO --- 如果参数不可以包括 NULL /空字符串 --- 如果不知道参数是否可以包括 null 
    private String scopeCatlog;             //表的类别，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null） 
    private String scopeSchema;             //表的模式，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null） 
    private String scopeTable;              //表名称，它是引用属性的作用域（如果 DATA_TYPE 不是 REF，则为 null） 
    private short sourceDataType;           //不同类型或用户生成 Ref 类型、来自 java.sql.Types 的 SQL 类型的源类型（如果 DATA_TYPE 不是 DISTINCT 或用户生成的 REF，则为 null）
    private String isAutoincrement;         //示此列是否自动增加 YES --- 如果该列自动增加 /NO --- 如果该列不自动增加 /空字符串 --- 如果不能确定该列是否是自动增加参数 
    private boolean isEnable = true;
    
    private String columnNameField;         //字段名称的Class驼峰表示
    private String columnNameMethodField;   //字段名称的Class驼峰表示,第一个字母大写
    private String typeNameField;           //字段类型的权限定包XX.XX.XX
    private boolean key = false;            //是否为主键
    
    public ColumnInfo() {
        super();
    }

    public ColumnInfo(String tableCat, String tableSchem, String tableName, String columnName, int dataType, String typeName, int columnSize, String bufferLength, int decimalDigits,
            String numPrecRadix, int nullable, String remarks, String columnDef, int sqlDataType, int sqlDatetimeSub, int charOctetLength, int ordinalPosition, String isNullable, String scopeCatlog,
            String scopeSchema, String scopeTable, short sourceDataType, String isAutoincrement) {
        super();
        this.tableCat = tableCat;
        this.tableSchem = tableSchem;
        this.tableName = tableName;
        this.columnName = columnName;
        this.dataType = dataType;
        this.typeName = typeName;
        this.columnSize = columnSize;
        this.bufferLength = bufferLength;
        this.decimalDigits = decimalDigits;
        this.numPrecRadix = numPrecRadix;
        this.nullable = nullable;
        this.remarks = remarks;
        this.columnDef = columnDef;
        this.sqlDataType = sqlDataType;
        this.sqlDatetimeSub = sqlDatetimeSub;
        this.charOctetLength = charOctetLength;
        this.ordinalPosition = ordinalPosition;
        this.isNullable = isNullable;
        this.scopeCatlog = scopeCatlog;
        this.scopeSchema = scopeSchema;
        this.scopeTable = scopeTable;
        this.sourceDataType = sourceDataType;
        this.isAutoincrement = isAutoincrement;
    }

    @Override
    public String toString() {
        return "ColumnInfo [tableCat=" + tableCat + ", tableSchem=" + tableSchem + ", tableName=" + tableName + ", columnName=" + columnName + ", dataType=" + dataType + ", typeName=" + typeName
                + ", columnSize=" + columnSize + ", bufferLength=" + bufferLength + ", decimalDigits=" + decimalDigits + ", numPrecRadix=" + numPrecRadix + ", nullable=" + nullable + ", remarks="
                + remarks + ", columnDef=" + columnDef + ", sqlDataType=" + sqlDataType + ", sqlDatetimeSub=" + sqlDatetimeSub + ", charOctetLength=" + charOctetLength + ", ordinalPosition="
                + ordinalPosition + ", isNullable=" + isNullable + ", scopeCatlog=" + scopeCatlog + ", scopeSchema=" + scopeSchema + ", scopeTable=" + scopeTable + ", sourceDataType="
                + sourceDataType + ", isAutoincrement=" + isAutoincrement + ", isEnable=" + isEnable + "]";
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
        return columnName.toUpperCase();
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(int columnSize) {
        this.columnSize = columnSize;
    }

    public String getBufferLength() {
        return bufferLength;
    }

    public void setBufferLength(String bufferLength) {
        this.bufferLength = bufferLength;
    }

    public int getDecimalDigits() {
        return decimalDigits;
    }

    public void setDecimalDigits(int decimalDigits) {
        this.decimalDigits = decimalDigits;
    }

    public String getNumPrecRadix() {
        return numPrecRadix;
    }

    public void setNumPrecRadix(String numPrecRadix) {
        this.numPrecRadix = numPrecRadix;
    }

    public int getNullable() {
        return nullable;
    }

    public void setNullable(int nullable) {
        this.nullable = nullable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getColumnDef() {
        return columnDef;
    }

    public void setColumnDef(String columnDef) {
        this.columnDef = columnDef;
    }

    public int getSqlDataType() {
        return sqlDataType;
    }

    public void setSqlDataType(int sqlDataType) {
        this.sqlDataType = sqlDataType;
    }

    public int getSqlDatetimeSub() {
        return sqlDatetimeSub;
    }

    public void setSqlDatetimeSub(int sqlDatetimeSub) {
        this.sqlDatetimeSub = sqlDatetimeSub;
    }

    public int getCharOctetLength() {
        return charOctetLength;
    }

    public void setCharOctetLength(int charOctetLength) {
        this.charOctetLength = charOctetLength;
    }

    public int getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(int ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getScopeCatlog() {
        return scopeCatlog;
    }

    public void setScopeCatlog(String scopeCatlog) {
        this.scopeCatlog = scopeCatlog;
    }

    public String getScopeSchema() {
        return scopeSchema;
    }

    public void setScopeSchema(String scopeSchema) {
        this.scopeSchema = scopeSchema;
    }

    public String getScopeTable() {
        return scopeTable;
    }

    public void setScopeTable(String scopeTable) {
        this.scopeTable = scopeTable;
    }

    public short getSourceDataType() {
        return sourceDataType;
    }

    public void setSourceDataType(short sourceDataType) {
        this.sourceDataType = sourceDataType;
    }

    public String getIsAutoincrement() {
        return isAutoincrement;
    }

    public void setIsAutoincrement(String isAutoincrement) {
        this.isAutoincrement = isAutoincrement;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public String getColumnNameField() {
        return CamelCaseUtil.toCamelCase(columnName);
    }

    public String getTypeNameField() {
        return ConstantMap.sql2JavaMap.get(typeName);
    }

    public String getColumnNameMethodField() {
        return CamelCaseUtil.toClassName(columnName);
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }
}
