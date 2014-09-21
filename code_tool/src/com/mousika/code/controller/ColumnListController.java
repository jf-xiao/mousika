package com.mousika.code.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Column;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;

import com.alibaba.fastjson.JSON;
import com.mousika.code.bean.ColumnsUtil;
import com.mousika.code.bean.CustomColumnBean;
import com.mousika.code.bean.CustomTableBean;
import com.mousika.code.bean.PageBean;
/**
 * 获取代码自动生成器的默认配置信息
 * @author xiaojf
 *
 */
public class ColumnListController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("rows"));
        String tableName = request.getParameter("tableName");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        List<CustomColumnBean> columnBeans = new ArrayList<CustomColumnBean>();
        PrintWriter out = response.getWriter();
        List<Column> cols = (List<Column>) ColumnsUtil.getColumnsByTableName(tableName.toLowerCase());
        
        for (Column column : cols) {
            columnBeans.add(new CustomColumnBean(column.getRemarks(), column.getSqlName(), column.getJavaType(), column.getJdbcSqlTypeName(), column.isPk(), column.isNullable(), column.isUnique()));
        }
        
        if(columnBeans != null && columnBeans.size() > 0){
            int total = columnBeans.size();
            int start = (page - 1) * rows ;
            int end = (page * rows);
            if(end > total){
                end = total;
            }
            
            PageBean pageBean = new PageBean();
            List list = columnBeans.subList(start, end);
            pageBean.setRows(list);
            pageBean.setTotal(total);
            
            out.write(JSON.toJSONString(pageBean));
        }
    }
}
