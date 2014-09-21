package cn.org.rapid_framework.generator;

import java.io.IOException;


/**
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */

public class GeneratorMain {
	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) {
	    generator();

	}
	
	public static void generator(){
	       GeneratorFacade g = new GeneratorFacade();
	        
//	      g.printAllTableNames();             //打印数据库中的表名称
	        
	        try {
	            g.deleteOutRootDir();
//	          g.generateByTable("table_name","template"); //通过数据库表生成文件,template为模板的根目录
	            g.generateByAllTable("template");   //自动搜索数据库中的所有表并生成文件,template为模板的根目录
//	          g.generateByClass(Blog.class,"template_clazz");
	            
//	          g.deleteByTable("table_name", "template"); //删除生成的文件
	            //打开文件夹
	          Runtime.getRuntime().exec("cmd.exe /c start "+GeneratorProperties.getRequiredProperty("outRoot"));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }//删除生成器的输出目录
	        catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
}
