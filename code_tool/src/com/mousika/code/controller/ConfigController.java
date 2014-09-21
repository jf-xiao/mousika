package com.mousika.code.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.org.rapid_framework.generator.GeneratorProperties;

import com.alibaba.fastjson.JSON;
/**
 * 获取代码自动生成器的默认配置信息
 * @author xiaojf
 *
 */
public class ConfigController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        Properties properties = GeneratorProperties.getProperties();
        out.write(JSON.toJSONString(properties));
    }
}
