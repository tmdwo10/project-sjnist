package com.project.sjnist.common.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.sjnist.common.service.CommonService;

@RestController
@RequestMapping("/common")
public class CommonRestController {
	
	private final CommonService commonService;
	
	public CommonRestController(CommonService commonService) {
		this.commonService = commonService;
	}
	
	@PostMapping(value="/signUp")
	public int signUp(@RequestParam Map<String, Object> params) {
		
		int resp = commonService.signUp(params);
		
		return resp;
	}
	
}
