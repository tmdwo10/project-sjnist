package com.project.sjnist.common.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonMapper {
	
	public int signUp(Map<String, Object> param);
	
	public int validateId(Map<String, Object> param);
	
	public String login(String id);
	
}
