package com.mousika.tool.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigInfo {
    public static Map<Constants ,TemplateConfigInfo> tempConfigMap = new HashMap<Constants, TemplateConfigInfo>();
    public static JdbcConfigInfo jdbcConfigInfo;
    public static List<TableInfo> tableInfos = new ArrayList<TableInfo>();
    public static Map<String,List<ColumnInfo>> tabAndcolMap = new HashMap<String, List<ColumnInfo>>();
    public static String outputPath = "";
}
