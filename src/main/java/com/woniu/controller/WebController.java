package com.woniu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woniu.RedisComponent.RedisComponent;

@RestController
@RequestMapping(value="/web")
public class WebController {
	
	@Autowired
	private RedisComponent redisComponet;
	
	@RequestMapping(value="/set/{key}/{value}")
	public String set(@PathVariable String key, @PathVariable String value){
		redisComponet.set(key, value);
		
		return "set key succ!";
	}
	
	@RequestMapping(value="/get/{key}")
	public String get(@PathVariable String key){
		return redisComponet.get(key);
	}
	
	@RequestMapping(value="/del/{key}")
	public void del(@PathVariable String key){
		redisComponet.del(key);
	}
}
