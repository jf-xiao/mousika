package com.mousika.tool.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mousika.tool.bean.JdbcConfigInfo;
import com.mousika.tool.bean.PrimaryKeyInfo;


public class PrimaryKeyUtil {
    
    public static List<PrimaryKeyInfo> getTablePks(JdbcConfigInfo jdbcConfigInfo , String tableName){
        List<PrimaryKeyInfo> primaryKeyInfos = new ArrayList<PrimaryKeyInfo>();
        try {
            Connection conn = ConnectionUtil.getInstance(jdbcConfigInfo).getConnection();
            DatabaseMetaData dbMeta = conn.getMetaData();
            ResultSet pkRSet = dbMeta.getPrimaryKeys(null, null, tableName);
            while (pkRSet.next()) {
                PrimaryKeyInfo primaryKeyInfo = new PrimaryKeyInfo();
                primaryKeyInfo.setTableCat(pkRSet.getString("TABLE_CAT"));
                primaryKeyInfo.setColumnName(pkRSet.getString("COLUMN_NAME"));
                primaryKeyInfo.setKeySeq(pkRSet.getShort("KEY_SEQ"));
                primaryKeyInfo.setPkName(pkRSet.getString("PK_NAME"));
                primaryKeyInfo.setTableName(pkRSet.getString("TABLE_NAME"));
                primaryKeyInfo.setTableSchem(pkRSet.getString("TABLE_SCHEM"));
                primaryKeyInfos.add(primaryKeyInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return primaryKeyInfos;
    }

    public static void main(String[] args) {
        try {
            Connection conn = ConnectionUtil.getInstance().getConnection();
            DatabaseMetaData dbMeta = conn.getMetaData();
            ResultSet pkRSet = dbMeta.getPrimaryKeys(null, null, "us_user");
            while (pkRSet.next()) {
                System.out.println(pkRSet.getObject("TABLE_CAT") + "");
                System.out.println(pkRSet.getObject("TABLE_SCHEM") + "");
                System.out.println(pkRSet.getObject("TABLE_NAME") + "");
                System.out.println(pkRSet.getObject("COLUMN_NAME") + "");
                System.out.println(pkRSet.getObject("KEY_SEQ") + "");
                System.out.println(pkRSet.getObject("PK_NAME") + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
