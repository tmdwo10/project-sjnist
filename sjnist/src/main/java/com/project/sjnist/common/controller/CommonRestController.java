package com.project.sjnist.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sjnist.common.service.CommonService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/common")
public class CommonRestController {
	
	private final CommonService commonService;
	
	public CommonRestController(CommonService commonService) {
		this.commonService = commonService;
	}
	
	@PostMapping(value="/signUp")
	public Map<String, Object> signUp(@RequestBody Map<String, Object> params) {
		Map<String, Object> result = new HashMap<>();
		
		try {
			int count = commonService.signUp(params);
			result.put("success", count > 0);
			result.put("message", count > 0 ? "회원가입 성공" : "회원가입 실패");
		}catch(Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		
		return result;
	}
	
	@PostMapping(value="/validateId")
	public Map<String, Object> validateId(@RequestBody Map<String, Object> params){
		Map<String, Object> result = new HashMap<>();
		
		try {
			int count = commonService.validateId(params);
			result.put("success", true);
			result.put("message", count > 0 ? "중복" : "사용가능");
			result.put("result", count > 0 ? "Y" : "N");
		}catch(Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		
		return result;
	}
	
	@PostMapping(value="/login")
	public Map<String, Object> login(@RequestBody Map<String, Object> params, HttpSession session){
		Map<String, Object> result = new HashMap<>();
		
		try {
			int count = commonService.login(params);
			if(count > 0) {
				session.setAttribute("loginUser", params.get("id"));
				result.put("success", true);
			}else {
				result.put("success", false);
				result.put("message", "아이디/비밀번호를 확인해주세요.");
			}
		}catch(Exception e) {
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		
		return result;
	}
	
}
