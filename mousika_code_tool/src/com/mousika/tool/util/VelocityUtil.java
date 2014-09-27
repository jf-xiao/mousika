package com.mousika.tool.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class VelocityUtil {
    public static void generator(Object params,String templateName,String outputPath,String fileName){
        try {
            VelocityEngine ve = new VelocityEngine();
            ve.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            ve.setProperty(VelocityEngine.INPUT_ENCODING, "utf-8");
            ve.setProperty(VelocityEngine.OUTPUT_ENCODING, "utf-8");
            ve.init();
            Template template = ve.getTemplate(templateName);
            VelocityContext context = new VelocityContext();
            context.put("params", params);
            File file = new File(outputPath);
            if(!file.exists()){
                file.mkdirs();
            }
            Writer writer = new PrintWriter(outputPath+"/"+fileName);
            template.merge(context, writer);
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
    
    public static void main(String[] args) {
        /*try {
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
        }*/
        
        generator("xiaojf hello world!!", "hello.html", UrlUtil.getRootPath()+"/template","helloworld.html");
    }
}
