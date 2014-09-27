package com.mousika.tool.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.Patch;

import com.mousika.tool.bean.ColumnInfo;
import com.mousika.tool.bean.ConfigInfo;
import com.mousika.tool.bean.Constants;
import com.mousika.tool.bean.DatabaseInfo;
import com.mousika.tool.bean.TableInfo;
import com.mousika.tool.bean.TemplateConfigInfo;
import com.mousika.tool.util.ConnectionUtil;
import com.mousika.tool.util.PathUtil;
import com.mousika.velocity.params.ServiceParams;

/**
 * 核心操作类
 * 
 * @author xiaojf
 * 
 */
public class MainOperate {

    public static String generatorFiles() {
        Map<Constants, TemplateConfigInfo> tempConfigMap = ConfigInfo.tempConfigMap;

        for (TableInfo tableInfo : ConfigInfo.tableInfos) {
            if (tableInfo.isEnable()) {
                if (tempConfigMap.get(Constants.ACTION).isEnable()) {
                    Generator.generatorAction(tableInfo);

                }
                if (tempConfigMap.get(Constants.MODEL).isEnable()) {

                    Generator.generatorModel(tableInfo);
                }
                if (tempConfigMap.get(Constants.DAO_IMPL).isEnable()) {

                    Generator.generatorDaoImpl(tableInfo);
                }
                if (tempConfigMap.get(Constants.DAO).isEnable()) {
                    Generator.generatorDao(tableInfo);

                }
                if (tempConfigMap.get(Constants.SERVICE_IMPL).isEnable()) {
                    Generator.generatorServiceImpl(tableInfo);

                }
                if (tempConfigMap.get(Constants.SERVICE).isEnable()) {
                    Generator.generatorService(tableInfo);

                }
            }
        }

        return "生产成功";
    }

    public static List<TableInfo> loadTableInfo(DatabaseInfo databaseInfo) {
        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = null;
        String[] types = null;
        List<TableInfo> tableInfos = new ArrayList<TableInfo>();
        Map<String, List<ColumnInfo>> tabAndcolMap = new HashMap<String, List<ColumnInfo>>();
        try {
            Connection conn = ConnectionUtil.getInstance().getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rs = metaData.getTables(catalog, schemaPattern, tableNamePattern, types);
            while (rs.next()) {
                List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();
                TableInfo tableInfo = new TableInfo(rs.getString("TABLE_CAT"), rs.getString("TABLE_SCHEM"),
                        rs.getString("TABLE_NAME"), rs.getString("TABLE_TYPE"), rs.getString("REMARKS"),
                        rs.getString("TYPE_CAT"), rs.getString("TYPE_SCHEM"), rs.getString("TYPE_NAME"),
                        rs.getString("SELF_REFERENCING_COL_NAME"), rs.getString("REF_GENERATION"));
                tableInfos.add(tableInfo);

                ResultSet rs2 = metaData.getColumns(null, null, tableInfo.getTableName(), null);
                while (rs2.next()) {
                    String tableCat = rs2.getString("TABLE_CAT");// 表类别（可为 null
                    String tableSchem = rs2.getString("TABLE_SCHEM");// 表模式（可为
                                                                     // null）
                    String tableName = rs2.getString("TABLE_NAME");// 表名称
                    String columnName = rs2.getString("COLUMN_NAME");// 列名称
                    int dataType = rs2.getInt("DATA_TYPE");// 来自 java.sql.Types
                                                           // 的 SQL 类型
                    String typeName = rs2.getString("TYPE_NAME");// 数据源依赖的类型名称，对于
                                                                 // UDT，该类型名称是完全限定的
                    int columnSize = rs2.getInt("COLUMN_SIZE");// 列的大小
                    String bufferLength = rs2.getString("BUFFER_LENGTH");// 未被使用
                    int decimalDigits = rs2.getInt("DECIMAL_DIGITS");// 小数部分的位数。对于
                                                                     // DECIMAL_DIGITS
                                                                     // 不适用的数据类型，则返回
                                                                     // Null。
                    String numPrecRadix = rs2.getString("NUM_PREC_RADIX");// 基数（通常为
                                                                          // 10
                                                                          // 或
                                                                          // 2）
                    int nullable = rs2.getInt("NULLABLE");// 是否允许使用 NULL。
                                                          // columnNoNulls /
                                                          // 可能不允许使用 NULL 值
                                                          // columnNullable /
                                                          // 明确允许使用 NULL 值
                                                          // columnNullableUnknown
                                                          // /不知道是否可使用 null
                    String remarks = rs2.getString("REMARKS");// 描述列的注释（可为 null）
                    String columnDef = rs2.getString("COLUMN_DEF");// 该列的默认值，当值在单引号内时应被解释为一个字符串（可为
                                                                   // null）
                    int sqlDataType = rs2.getInt("SQL_DATA_TYPE");// 未使用
                    int sqlDatetimeSub = rs2.getInt("SQL_DATETIME_SUB");// 未使用
                    int charOctetLength = rs2.getInt("CHAR_OCTET_LENGTH");// 对于
                                                                          // char
                                                                          // 类型，该长度是列中的最大字节数
                    int ordinalPosition = rs2.getInt("ORDINAL_POSITION");// 表中的列的索引（从
                                                                         // 1
                                                                         // 开始）
                    String isNullable = rs2.getString("IS_NULLABLE");// ISO
                                                                     // 规则用于确定列是否包括
                                                                     // null。
                                                                     // YES ---
                                                                     // 如果参数可以包括
                                                                     // NULL /NO
                                                                     // ---
                                                                     // 如果参数不可以包括
                                                                     // NULL
                                                                     // /空字符串
                                                                     // ---
                                                                     // 如果不知道参数是否可以包括
                                                                     // null
                    // String scopeCatlog =
                    // rs2.getString("SCOPE_CATLOG");//表的类别，它是引用属性的作用域（如果
                    // DATA_TYPE 不是 REF，则为 null）
                    String scopeCatlog = null;
                    String scopeSchema = rs2.getString("SCOPE_SCHEMA");// 表的模式，它是引用属性的作用域（如果
                                                                       // DATA_TYPE
                                                                       // 不是
                                                                       // REF，则为
                                                                       // null）
                    String scopeTable = rs2.getString("SCOPE_TABLE");// 表名称，它是引用属性的作用域（如果
                                                                     // DATA_TYPE
                                                                     // 不是
                                                                     // REF，则为
                                                                     // null）
                    short sourceDataType = rs2.getShort("SOURCE_DATA_TYPE");// 不同类型或用户生成
                                                                            // Ref
                                                                            // 类型、来自
                                                                            // java.sql.Types
                                                                            // 的
                                                                            // SQL
                                                                            // 类型的源类型（如果
                                                                            // DATA_TYPE
                                                                            // 不是
                                                                            // DISTINCT
                                                                            // 或用户生成的
                                                                            // REF，则为
                                                                            // null）
                    String isAutoincrement = rs2.getString("IS_AUTOINCREMENT");// 示此列是否自动增加
                                                                               // YES
                                                                               // ---
                                                                               // 如果该列自动增加
                                                                               // /NO
                                                                               // ---
                                                                               // 如果该列不自动增加
                                                                               // /空字符串
                                                                               // ---
                                                                               // 如果不能确定该列是否是自动增加参数

                    columnInfos.add(new ColumnInfo(tableCat, tableSchem, tableName, columnName, dataType, typeName,
                            columnSize, bufferLength, decimalDigits, numPrecRadix, nullable, remarks, columnDef,
                            sqlDataType, sqlDatetimeSub, charOctetLength, ordinalPosition, isNullable, scopeCatlog,
                            scopeSchema, scopeTable, sourceDataType, isAutoincrement));
                }
                tabAndcolMap.put(tableInfo.getTableName().toUpperCase(), columnInfos);
            }
            ConfigInfo.tableInfos = tableInfos;
            ConfigInfo.tabAndcolMap = tabAndcolMap;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableInfos;
    }
}
