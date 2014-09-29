package com.mousika.tool.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
/**
 * velocity 工具类
 *@author xiaojf 294825811@qq.com
 */
public class CodeToolGenerator {
    /**
     * code tool 文件生成器
     * @param params
     * @param temp
     * @param outputPath
     * @param fileName
     * @author xiaojf 294825811@qq.com
     */
    public static void generator(Object params,String temp,String outputPath,String fileName){
        try {
            //转换模板路径字符串 / - > \
            String tempPath = temp.subSequence(0, temp.lastIndexOf("\\")).toString().replace('\\', '/');
            //截取模板名
            String tempFile = temp.subSequence(temp.lastIndexOf("\\")+1,temp.length()).toString();
            outputPath = outputPath.replace('\\', '/');
            
            VelocityEngine ve = new VelocityEngine();
            //ve.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            //设置模板路径
            ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, tempPath);
            //模板读取编码格式
            ve.setProperty(VelocityEngine.INPUT_ENCODING, "utf-8");
            //文件输出编码格式
            ve.setProperty(VelocityEngine.OUTPUT_ENCODING, "utf-8");
            //初始化velocity
            ve.init();
            //获取模板
            Template template = ve.getTemplate(tempFile);
            VelocityContext context = new VelocityContext();
            //设置上下文参数值
            context.put("params", params);
            File file = new File(outputPath);
            //如果目录不存在,则创建
            if(!file.exists()){
                file.mkdirs();
            }
            Writer writer = new PrintWriter(outputPath+"/"+fileName);
            template.merge(context, writer);
            //输出文件
            writer.flush();
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        } catch (ParseErrorException e) {
            e.printStackTrace();
        } catch (MethodInvocationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
/*    public static void main(String[] args) {
        try {
            VelocityEngine ve = new VelocityEngine();
            ve.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            ve.setProperty(VelocityEngine.INPUT_ENCODING, "utf-8");
            ve.setProperty(VelocityEngine.OUTPUT_ENCODING, "utf-8");
            ve.init();
            Template template = ve.getTemplate("hello.html");
            VelocityContext context = new VelocityContext();
            context.put("name", "xiaojf hello world!!");
            String outputPath = UrlUtil.getRootPath()+"/template/helloworld.html";
            Writer writer = new PrintWriter(outputPath);
            template.merge(context, writer);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //generator("xiaojf hello world!!", "hello.html", UrlUtil.getRootPath()+"/template","helloworld.html");
        String templateName ="C:\\Users\\xiaojf\\Desktop\\mousika_code_tool\\template.vm";
        String tempPath = templateName.subSequence(0, templateName.lastIndexOf("\\")).toString().replace('\\', '/');
        String tempFile = templateName.subSequence(templateName.lastIndexOf("\\")+1,templateName.length()).toString();
        
        System.out.println(tempPath);
        System.out.println(tempFile);
    }*/
}
