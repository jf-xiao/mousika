package com.mousika.tool.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 页面配置
 * @author xiaojf 294825811@qq.com
 */
public class ConfigInfo {
    public static Map<Constants ,TemplateConfigInfo> tempConfigMap = new HashMap<Constants, TemplateConfigInfo>();  //模板配置
    public static JdbcConfigInfo jdbcConfigInfo;                                                                    //数据库连接池配置
    public static List<TableInfo> tableInfos = new ArrayList<TableInfo>();                                          //需要生产的表
    public static Map<String,List<ColumnInfo>> tabAndcolMap = new HashMap<String, List<ColumnInfo>>();              //表与字段的映射
    public static String outputPath = "";                                                                           //文件输出路径
    public static boolean onlyStreamOut = false;                                                                    //是否直接输出文件流

}
