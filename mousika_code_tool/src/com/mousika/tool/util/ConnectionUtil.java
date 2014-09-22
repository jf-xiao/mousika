package com.mousika.tool.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
    private static String username = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/mousika?useUnicode=true&amp;characterEncoding=UTF-8";
    private static String driverClass ="com.mysql.jdbc.Driver";
    private Connection conn ;
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(driverClass);
        return DriverManager.getConnection(url, username, password);
    }
    
    public static void releaseConn(Connection conn) throws SQLException{
        if(conn != null){
            conn.close();
        }
    }
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = null;
        String[] types = null;
        
        Connection conn = getConnection();
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getTables(catalog, schemaPattern, tableNamePattern, types);
        while(rs.next()){
            System.out.println(rs.getObject(3));
            System.out.println(rs.getObject(5));
        }
        System.out.println(metaData.getDatabaseProductName());
    }

}
