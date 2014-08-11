package com.mousika.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mousika.security.model.UsUser;

@Controller
public class UserController {
	@RequestMapping("/regist")
	public String regist(UsUser user,ModelMap model){
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		return "login.jsp";
	}
	@RequestMapping("/login")
	public String login(String username , String password){
		System.out.println(username);
		System.out.println(password);
		return "index.jsp";
	}
}
