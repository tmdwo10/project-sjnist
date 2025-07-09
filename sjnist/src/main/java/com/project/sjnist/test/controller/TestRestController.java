package com.project.sjnist.test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sjnist.test.service.TestService;

@RestController
@RequestMapping("/test")
public class TestRestController {
	
	private final TestService testService;
	
	public TestRestController(TestService testService) {
		this.testService = testService;
	}

	@PostMapping("/selectTest")
	public List<Map<String, Object>> selectTest(){
		return testService.selectTest();
	}
}
