package com.mousika.tool.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mousika.tool.bean.ColumnInfo;
import com.mousika.tool.bean.ConfigInfo;
import com.mousika.tool.bean.JdbcConfigInfo;
import com.mousika.tool.bean.TableInfo;
import com.mousika.tool.util.ConnectionUtil;

/**
 * MYSQL操作
 * @author xiaojf 294825811@qq.com
 */
public class MySqlOperator {
    
    /**
     * 加载表信息
     * @param jdbcConfigInfo jdbc配置信息
     * @return 所有的表信息
     * @author xiaojf 294825811@qq.com
     */
    public static List<TableInfo> loadTableInfo(JdbcConfigInfo jdbcConfigInfo) {
        List<TableInfo> tableInfos = new ArrayList<TableInfo>();                //表集合
        Map<String, List<ColumnInfo>> tabAndcolMap = new HashMap<String, List<ColumnInfo>>();   //表与字段的映射关系
        try {
            //获取链接
            Connection conn = ConnectionUtil.getInstance(jdbcConfigInfo).getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rs = metaData.getTables(null, null, null, null);
            //获取所有的表信息
            while (rs.next()) {
                TableInfo tableInfo = new TableInfo(rs.getString("TABLE_CAT"), rs.getString("TABLE_SCHEM"), rs.getString("TABLE_NAME"), rs.getString("TABLE_TYPE"), rs.getString("REMARKS"),
                        rs.getString("TYPE_CAT"), rs.getString("TYPE_SCHEM"), rs.getString("TYPE_NAME"), rs.getString("SELF_REFERENCING_COL_NAME"), rs.getString("REF_GENERATION"));
                //加入表集合
                tableInfos.add(tableInfo);
                
                List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();     //字段集合
                
                ResultSet rs2 = metaData.getColumns(null, null, tableInfo.getTableName(), null);
                //查询某张表的所有字段信息
                while (rs2.next()) {
                    String tableCat = rs2.getString("TABLE_CAT");               // 表类别（可为 null
                    String tableSchem = rs2.getString("TABLE_SCHEM");           // 表模式（可为null）
                    String tableName = rs2.getString("TABLE_NAME");             // 表名称
                    String columnName = rs2.getString("COLUMN_NAME");           // 列名称
                    int dataType = rs2.getInt("DATA_TYPE");                     // 来自 java.sql.Types的 SQL 类型
                    String typeName = rs2.getString("TYPE_NAME");               // 数据源依赖的类型名称，对于UDT，该类型名称是完全限定的
                    int columnSize = rs2.getInt("COLUMN_SIZE");                 // 列的大小
                    String bufferLength = rs2.getString("BUFFER_LENGTH");       // 未被使用
                    int decimalDigits = rs2.getInt("DECIMAL_DIGITS");           // 小数部分的位数。对于DECIMAL_DIGITS不适用的数据类型，则返回Null。
                    String numPrecRadix = rs2.getString("NUM_PREC_RADIX");      // 基数（通常为10或2）
                    int nullable = rs2.getInt("NULLABLE");                      // 是否允许使用 NULL。columnNoNulls /可能不允许使用 NULL 值columnNullable /明确允许使用 NULL 值columnNullableUnknown/不知道是否可使用 null
                    String remarks = rs2.getString("REMARKS");                  // 描述列的注释（可为 null）
                    String columnDef = rs2.getString("COLUMN_DEF");             // 该列的默认值，当值在单引号内时应被解释为一个字符串（可为// null）
                    int sqlDataType = rs2.getInt("SQL_DATA_TYPE");              // 未使用
                    int sqlDatetimeSub = rs2.getInt("SQL_DATETIME_SUB");        // 未使用
                    int charOctetLength = rs2.getInt("CHAR_OCTET_LENGTH");      // 对于char类型，该长度是列中的最大字节数
                    int ordinalPosition = rs2.getInt("ORDINAL_POSITION");       // 表中的列的索引（从1开始）
                    String isNullable = rs2.getString("IS_NULLABLE");           // ISO规则用于确定列是否包括null。YES ---如果参数可以包括NULL /NO---如果参数不可以包括NULL/空字符串---如果不知道参数是否可以包括null
                                                                                // String scopeCatlog =
                                                                                // rs2.getString("SCOPE_CATLOG");//表的类别，它是引用属性的作用域（如果
                                                                                // DATA_TYPE 不是 REF，则为 null）
                    String scopeCatlog = null;
                    String scopeSchema = rs2.getString("SCOPE_SCHEMA");         // 表的模式，它是引用属性的作用域（如果DATA_TYPE不是REF，则为null）
                    String scopeTable = rs2.getString("SCOPE_TABLE");           // 表名称，它是引用属性的作用域（如果DATA_TYPE不是REF，则为null）
                    short sourceDataType = rs2.getShort("SOURCE_DATA_TYPE");    // 不同类型或用户生成Ref类型、来自java.sql.Types的SQL类型的源类型（如果DATA_TYPE不是DISTINCT或用户生成的REF，则为null）
                    String isAutoincrement = rs2.getString("IS_AUTOINCREMENT"); // 示此列是否自动增加YES---如果该列自动增加/NO---如果该列不自动增加/空字符串---如果不能确定该列是否是自动增加参数

                    columnInfos.add(new ColumnInfo(tableCat, tableSchem, tableName, columnName, dataType, typeName, columnSize, bufferLength, decimalDigits, numPrecRadix, nullable, remarks,
                            columnDef, sqlDataType, sqlDatetimeSub, charOctetLength, ordinalPosition, isNullable, scopeCatlog, scopeSchema, scopeTable, sourceDataType, isAutoincrement));
                }
                tabAndcolMap.put(tableInfo.getTableName().toUpperCase(), columnInfos);
            }
            ConfigInfo.tableInfos = tableInfos;                                 //更新表信息
            ConfigInfo.tabAndcolMap = tabAndcolMap;                             //更新表与字段的映射关系
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableInfos;
    }

}
