package com.project.sjnist.common.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.sjnist.common.mapper.CommonMapper;

@Service
public class CommonService {
	
	private final CommonMapper commonMapper;
	
	public CommonService(CommonMapper commonMapper) {
		this.commonMapper = commonMapper;
	}

	public int signUp(@RequestParam Map<String, Object> param) {
		int resp = commonMapper.signUp();
		return resp;
	}
	
}
