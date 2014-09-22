package com.mousika.tool.bean;

import java.util.HashMap;
import java.util.Map;

public class ConstantMap {
    public static final Map<Integer,String> sqlTypeMap = new HashMap<Integer, String>();
    public    static final Map<String,String> sql2JavaMap = new HashMap<String, String>();
    
    static {
        sqlTypeMap.put(2003, "ARRAY");
        sqlTypeMap.put(-5, "BIGINT");
        sqlTypeMap.put(-2, "BINARY");
        sqlTypeMap.put(-7, "BIT");
        sqlTypeMap.put(2004, "BLOB");
        sqlTypeMap.put(16, "BOOLEAN");
        sqlTypeMap.put(1, "CHAR");
        sqlTypeMap.put(2005, "CLOB");
        sqlTypeMap.put(70, "DATALINK");
        sqlTypeMap.put(91, "DATE");
        sqlTypeMap.put(3, "DECIMAL");
        sqlTypeMap.put(2001, "DISTINCT");
        sqlTypeMap.put(8, "DOUBLE");
        sqlTypeMap.put(6, "FLOAT");
        sqlTypeMap.put(4, "INTEGER");
        sqlTypeMap.put(2000, "JAVA_OBJECT");
        sqlTypeMap.put(-16, "LONGNVARCHAR");
        sqlTypeMap.put(-4, "LONGVARBINARY");
        sqlTypeMap.put(-1, "LONGVARCHAR");
        sqlTypeMap.put(-15, "NCHAR");
        sqlTypeMap.put(2011, "NCLOB");
        sqlTypeMap.put(0, "NULL");
        sqlTypeMap.put(2, "NUMERIC");
        sqlTypeMap.put(-9, "NVARCHAR");
        sqlTypeMap.put(1111, "OTHER");
        sqlTypeMap.put(7, "REAL");
        sqlTypeMap.put(2006, "REF");
        sqlTypeMap.put(-8, "ROWID");
        sqlTypeMap.put(5, "SMALLINT");
        sqlTypeMap.put(2009, "SQLXML");
        sqlTypeMap.put(2002, "STRUCT");
        sqlTypeMap.put(92, "TIME");
        sqlTypeMap.put(93, "TIMESTAMP");
        sqlTypeMap.put(-6, "TINYINT");
        sqlTypeMap.put(-3, "VARBINARY");
        sqlTypeMap.put(12, "VARCHAR");
        
        //---------------------------------------
        
        sql2JavaMap.put("ARRAY","java.lang.reflect.Array");
        sql2JavaMap.put("BIGINT","java.lang.Long");
        sql2JavaMap.put("BINARY","byte[]");
        sql2JavaMap.put("BIT","java.lang.Boolean");
        sql2JavaMap.put("BLOB","byte[]");
        sql2JavaMap.put("BOOLEAN","java.lang.Boolean");
        sql2JavaMap.put("CHAR","java.lang.Character");
        sql2JavaMap.put("CLOB","java.lang.String");
        sql2JavaMap.put("DATALINK","java.net.URL");
        sql2JavaMap.put("DATE","java.lang.Date");
        sql2JavaMap.put("DECIMAL","java.math.BigDecimal");
        sql2JavaMap.put("DISTINCT","java.lang.Object");
        sql2JavaMap.put("DOUBLE","java.lang.Double");
        sql2JavaMap.put("FLOAT","java.lang.Float");
        sql2JavaMap.put("INTEGER","java.lang.Integer");
        sql2JavaMap.put("JAVA_OBJECT","java.lang.Object");
        sql2JavaMap.put("LONGNVARCHAR","java.lang.String");
        sql2JavaMap.put("LONGVARBINARY","byte[]");
        sql2JavaMap.put("LONGVARCHAR","java.lang.String");
        sql2JavaMap.put("NCHAR","java.lang.Character");
        sql2JavaMap.put("NCLOB","java.lang.String");
        sql2JavaMap.put("NULL","null");
        sql2JavaMap.put("NUMERIC","java.math.BigDecimal");
        sql2JavaMap.put("NVARCHAR","java.lang.String");
        sql2JavaMap.put("OTHER","java.lang.Object");
        sql2JavaMap.put("REAL","java.lang.Float");
        sql2JavaMap.put("REF","java.lang.Object");
        sql2JavaMap.put("ROWID","java.lang.Object");
        sql2JavaMap.put("SMALLINT","java.lang.Integer");
        sql2JavaMap.put("SQLXML","java.lang.Object");
        sql2JavaMap.put("STRUCT","java.sql.Struct");
        sql2JavaMap.put("TIME","java.sql.Time");
        sql2JavaMap.put("TIMESTAMP","java.util.Date");
        sql2JavaMap.put("TINYINT","java.lang.Bute");
        sql2JavaMap.put("VARBINARY","byte[]");
        sql2JavaMap.put("VARCHAR","java.lang.String");
    }
}
