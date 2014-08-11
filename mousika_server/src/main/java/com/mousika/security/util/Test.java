package com.mousika.security.util;

import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class Test {
	private static Logger log = Logger.getLogger(Test.class); 

	/**
	 * @param args
	 * @author jianfeng.xiao@foxmail.com 2014-4-27 上午11:15:27
	 */
	public static void main(String[] args) {
		// 定义结果集
		ResultSet rs = null;
		SecurityJdbcUtil sql = new SecurityJdbcUtil();
		// 结果集

		// rs = sql.executeQuery("select * from studentInfo");
		// 调用有2个参数的查询方法
		rs = sql.executeQuery("select * from US_USER");
		try {
			// 循环取出结果集中的字段
			while (rs.next()) {
				// 从结果集中取得特定字段并输出
				log.error(rs.getString("USER_ID"));
				log.info(rs.getString("NAME"));
				System.out.println();
			}

			// 关闭结果集，必须关闭
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
