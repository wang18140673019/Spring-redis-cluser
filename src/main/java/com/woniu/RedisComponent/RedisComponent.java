package com.woniu.RedisComponent;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.woniu.bean.User;


//@Component
@Service("redisService")
public class RedisComponent {
	
	@Autowired
	//操作字符串的template，StringRedisTemplate是RedisTemplate的一个子集
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	// RedisTemplate，可以进行所有的操作  
	private RedisTemplate<Object,Object> redisTemplate;
	
	public void set(String key, String value){
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		boolean bExistent = this.stringRedisTemplate.hasKey(key);
		if (bExistent) {
			System.out.println("this key is bExistent!");
			ops.set(key, value);
		}else{
			ops.set(key, value);
		}
	}
	
	public String get(String key){
		return this.stringRedisTemplate.opsForValue().get(key);
	}
	
	public void del(String key){
		this.stringRedisTemplate.delete(key);
	}
	
	public void sentinelSet(User user){
		String key = null;
		try {
			key = new String(user.getId().getBytes("gbk"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(key);
		redisTemplate.opsForValue().set(key, user.toString());
	}
	
	public String sentinelGet(String key){
		return stringRedisTemplate.opsForValue().get(key);
	}
}
