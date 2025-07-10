package com.project.sjnist.common.service;

import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.sjnist.common.mapper.CommonMapper;

@Service
public class CommonService {
	
	private final CommonMapper commonMapper;
	private final PasswordEncoder passwordEncoder;
	
	public CommonService(CommonMapper commonMapper, PasswordEncoder passwordEncoder) {
		this.commonMapper = commonMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public int signUp(Map<String, Object> param) {
		String rawPass = (String) param.get("password");
		String encodedPass = passwordEncoder.encode(rawPass);
		
		param.put("password", encodedPass);
		
		return commonMapper.signUp(param);
	}
	
	public int validateId(Map<String, Object> param) {
		int resp = commonMapper.validateId(param);
		return resp;
	}
	
	public int login(Map<String, Object> param) {
		String id = (String) param.get("id");
		String rawPassword = (String) param.get("password");
		
		String encodedPassword = commonMapper.login(id);
		
		if(passwordEncoder.matches(rawPassword, encodedPassword)) {
			return 1;
		}
		
		return 0;
	}
	
}
