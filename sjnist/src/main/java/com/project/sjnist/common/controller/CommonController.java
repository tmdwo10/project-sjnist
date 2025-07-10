package com.project.sjnist.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommonController {
	
	@RequestMapping("/main")
	public String main() {
		return "common/main";
	}
	
	@RequestMapping("/myskills")
	public String myskills() {
		return "common/myskills";
	}
	
	@RequestMapping("portfolio")
	public String portfolio() {
		return "common/portfolio";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "common/contact";
	}
	
	@RequestMapping("/signUp")
	public String signUp() {
		return "common/signUp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "common/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) session.invalidate();
		return "common/main";
	}
	
}
