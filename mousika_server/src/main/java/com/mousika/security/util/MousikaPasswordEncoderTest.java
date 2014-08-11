package com.mousika.security.util;

import com.mousika.security.service.MousikaPasswordEncoder;

public class MousikaPasswordEncoderTest {

	/**
	 * @param args
	 * @author jianfeng.xiao@foxmail.com
	 * 2014-4-27 下午4:38:07 
	 */
	public static void main(String[] args) {
		MousikaPasswordEncoder encoder = new MousikaPasswordEncoder();
		String str = encoder.encodePassword("mousika", "mousika");
		System.out.println(str);
	}

}
