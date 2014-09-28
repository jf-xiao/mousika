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

public class OracleOperator {

    private static Map<String, List<ColumnInfo>> tabAndcolMap = new HashMap<String, List<ColumnInfo>>();

    public static List<TableInfo> loadTableInfo(JdbcConfigInfo jdbcConfigInfo) {
        List<TableInfo> tableInfos = new ArrayList<TableInfo>();
        try {
            Connection conn = ConnectionUtil.getInstance(jdbcConfigInfo).getConnection();
            //获取Oracle当前用户下的所有表和注释
            ResultSet rs = conn.prepareStatement("SELECT T.TABLE_NAME,C.COMMENTS FROM USER_TAB_COMMENTS C ,USER_TABLES T WHERE C.TABLE_NAME = T.TABLE_NAME").executeQuery();

            while (rs.next()) {
                List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();
                
                TableInfo tableInfo = new TableInfo();
                String tableName = rs.getString("TABLE_NAME");
                tableInfo.setTableName(tableName);//表名
                tableInfo.setRemarks(rs.getString("COMMENTS"));//注释
                tableInfos.add(tableInfo);

                ResultSet rs2 = conn.prepareStatement("SELECT * FROM USER_TAB_COLUMNS C WHERE C.TABLE_NAME = '"+tableName+"'").executeQuery();
                while (rs2.next()) {
                    
                    ColumnInfo columnInfo = new ColumnInfo();
                    columnInfo.setTableName(rs2.getString("TABLE_NAME"));
                    columnInfo.setColumnName(rs2.getString("COLUMN_NAME"));
                    columnInfo.setTypeName(rs2.getString("DATA_TYPE"));
                    columnInfo.setColumnSize(rs2.getInt("DATA_LENGTH"));
                    columnInfo.setNullable(rs2.getString("NULLABLE").toUpperCase().equals("N") ? 0 : 1 );
                    
                    String columnName = rs2.getString("COLUMN_NAME");
                    
                    ResultSet rs3 = conn.prepareStatement("SELECT COMMENTS FROM USER_COL_COMMENTS WHERE TABLE_NAME='"+tableName+"' AND COLUMN_NAME ='"+columnName+"'").executeQuery();
                    
                    while(rs3.next()){
                        columnInfo.setRemarks(rs3.getString("COMMENTS"));
                    }
                    
                    if(columnInfo.getRemarks() == null){
                        columnInfo.setRemarks("");
                    }
                    
                    columnInfos.add(columnInfo);
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
