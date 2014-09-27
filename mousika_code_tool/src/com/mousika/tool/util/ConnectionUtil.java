package com.mousika.tool.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mousika.tool.bean.DatabaseInfo;
import com.mousika.tool.bean.JdbcConfigInfo;

public class ConnectionUtil {
    private static String username = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/mousika?useUnicode=true&amp;characterEncoding=UTF-8";
    private static String driverClass ="com.mysql.jdbc.Driver";
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    private static ConnectionUtil instance= null;
    
    private ConnectionUtil(){
    }
    
    public static ConnectionUtil getInstance(DatabaseInfo databaseInfo){
        if(instance == null){
            url = databaseInfo.getUrl();
            driverClass = databaseInfo.getDriverClass();
            username = databaseInfo.getUsername();
            password = databaseInfo.getPassword();
            instance = new ConnectionUtil();
        }
        return instance;
    }
    
    public static ConnectionUtil getInstance(JdbcConfigInfo jdbcConfigInfo){
        if(instance == null){
            url = jdbcConfigInfo.getUrl();
            driverClass = jdbcConfigInfo.getDriverClass();
            username = jdbcConfigInfo.getUsername();
            password = jdbcConfigInfo.getPassword();
            instance = new ConnectionUtil();
        }
        return instance;
    }
    
    public static ConnectionUtil getInstance(){
        if(instance == null){
            instance = new ConnectionUtil();
        }
        return instance;
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        if(threadLocal.get() == null){
            Class.forName(driverClass);
            threadLocal.set(DriverManager.getConnection(url, username, password));
        }
        
        return threadLocal.get();
    }
    
    public void releaseConn() throws SQLException{
        if(threadLocal.get() != null){
            threadLocal.get().close();
        }
    }
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = null;
        String[] types = null;
        
        Connection conn = ConnectionUtil.getInstance().getConnection();
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getTables(catalog, schemaPattern, tableNamePattern, types);
        while(rs.next()){
            System.out.println(rs.getObject(3));
            System.out.println(rs.getObject(5));
        }
        System.out.println(metaData.getDatabaseProductName());
    }

}
