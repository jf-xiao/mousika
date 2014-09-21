package com.mousika.code.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;

import com.alibaba.fastjson.JSON;
import com.mousika.code.bean.CustomTableBean;
import com.mousika.code.bean.PageBean;
/**
 * 获取表字段的详细信息
 * @author xiaojf
 *
 */
public class TableListController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("rows"));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        
        List<Table> tables = TableFactory.getInstance().getAllTables();
        List<CustomTableBean> beans = new ArrayList<CustomTableBean>();
        for(Table t : tables){
            beans.add(new CustomTableBean(t.getTableAlias(), t.getClassName(), t.getSqlName()));
        }
        
        int total = beans.size();
        int start = (page - 1) * rows ;
        int end = (page * rows);
        if(end > total){
            end = total;
        }
        
        PageBean pageBean = new PageBean();
        pageBean.setRows(beans.subList(start, end));
        pageBean.setTotal(total);
        
        out.write(JSON.toJSONString(pageBean));
    }
}
