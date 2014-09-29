package com.mousika.tool.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mousika.tool.bean.DatabaseInfo;
import com.mousika.tool.bean.JdbcConfigInfo;

/**
 * 创建数据库连接工具类
 * @author xiaojf 294825811@qq.com
 */
public class ConnectionUtil {
    private static String username = "";        //用户名
    private static String password = "";        //密码
    private static String url = "";             //连接url
    private static String driverClass ="";      //数据库驱动类
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    private static ConnectionUtil instance= null;
    
    private ConnectionUtil(){
    }
    
    /**
     * 获取工具类对象
     * @param databaseInfo  jdbc配置信息
     * @return
     * @author xiaojf 294825811@qq.com
     */
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
    
    /**
     * 获取工具类对象
     * @param jdbcConfigInfo jdbc配置信息
     * @return
     * @author xiaojf 294825811@qq.com
     */
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
    
    /**
     * 获取工具类对象
     * @return
     * @author xiaojf 294825811@qq.com
     */
    public static ConnectionUtil getInstance(){
        if(instance == null){
            instance = new ConnectionUtil();
        }
        return instance;
    }
    
    /**
     * 获取连接对象
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @author xiaojf 294825811@qq.com
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        if(threadLocal.get() == null){
            Class.forName(driverClass);
            threadLocal.set(DriverManager.getConnection(url, username, password));
        }
        
        return threadLocal.get();
    }
    
    /**
     * 释放连接资源
     * @throws SQLException
     * @author xiaojf<br/>
     * 创建日期: 2014年9月29日 上午11:20:45
     */
    public void releaseConn() throws SQLException{
        if(threadLocal.get() != null){
            threadLocal.get().close();
        }
    }
    
/*    public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
    }*/

}
