package com.project.sjnist.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
}
