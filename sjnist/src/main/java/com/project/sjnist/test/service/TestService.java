package com.project.sjnist.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.sjnist.test.mapper.TestMapper;

@Service
public class TestService {

	private final TestMapper testMapper;
	
	public TestService (TestMapper testMapper) {
		this.testMapper = testMapper;
	}
	
	public List<Map<String, Object>> selectTest(){
		return testMapper.selectTest();
	}
}
