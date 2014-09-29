package com.mousika.tool.core;

import java.sql.Connection;
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
public class OracleOperator {

    /**
     * 加载表信息
     * @param jdbcConfigInfo jdbc配置信息
     * @return 所有的表信息
     * @author xiaojf 294825811@qq.com
     */
    private static Map<String, List<ColumnInfo>> tabAndcolMap = new HashMap<String, List<ColumnInfo>>();    //表与字段的映射
    
    /**
     * 加载表信息
     * @param jdbcConfigInfo jdbc配置信息
     * @return 所有的表信息
     * @author xiaojf 294825811@qq.com
     */
    public static List<TableInfo> loadTableInfo(JdbcConfigInfo jdbcConfigInfo) {
        List<TableInfo> tableInfos = new ArrayList<TableInfo>();    //表集合
        
        try {
            //获取链接
            Connection conn = ConnectionUtil.getInstance(jdbcConfigInfo).getConnection();
            //获取Oracle当前用户下的所有表和注释
            ResultSet rs = conn.prepareStatement("SELECT T.TABLE_NAME,C.COMMENTS FROM USER_TAB_COMMENTS C ,USER_TABLES T WHERE C.TABLE_NAME = T.TABLE_NAME").executeQuery();
            //加载表信息
            while (rs.next()) {
                TableInfo tableInfo = new TableInfo();
                String tableName = rs.getString("TABLE_NAME");                                              //表名
                tableInfo.setTableName(tableName);                                                          //表名
                tableInfo.setRemarks(rs.getString("COMMENTS"));                                             //注释
                tableInfos.add(tableInfo);

                List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();
                ResultSet rs2 = conn.prepareStatement("SELECT * FROM USER_TAB_COLUMNS C WHERE C.TABLE_NAME = '"+tableName+"'").executeQuery();
                //加载某张表的所有字段
                while (rs2.next()) {
                    ColumnInfo columnInfo = new ColumnInfo();                                               //字段信息
                    columnInfo.setTableName(rs2.getString("TABLE_NAME"));                                   //表名
                    String columnName = rs2.getString("COLUMN_NAME");                                       //字段名
                    columnInfo.setColumnName(columnName);
                    columnInfo.setTypeName(rs2.getString("DATA_TYPE"));                                     //类型
                    columnInfo.setColumnSize(rs2.getInt("DATA_LENGTH"));                                    //长度
                    columnInfo.setNullable(rs2.getString("NULLABLE").toUpperCase().equals("N") ? 0 : 1 );   //是否允许为空
                    
                    ResultSet rs3 = conn.prepareStatement("SELECT COMMENTS FROM USER_COL_COMMENTS WHERE TABLE_NAME='"+tableName+"' AND COLUMN_NAME ='"+columnName+"'").executeQuery();
                    //加载字段注释
                    while(rs3.next()){
                        columnInfo.setRemarks(rs3.getString("COMMENTS"));                                   //字段注释
                    }
                    
                    //如果字段没有注释
                    if(columnInfo.getRemarks() == null){
                        columnInfo.setRemarks("");
                    }
                    
                    columnInfos.add(columnInfo);
                }
                //更新表与字段的映射
                tabAndcolMap.put(tableInfo.getTableName().toUpperCase(), columnInfos);
            }
            ConfigInfo.tableInfos = tableInfos;                                                             //更新表集合
            ConfigInfo.tabAndcolMap = tabAndcolMap;                                                         //更新表与字段的映射
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableInfos;
    }

}
