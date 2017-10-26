package com.woniu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.RedisComponent.RedisComponent;
import com.woniu.bean.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSentinelredisApplicationTests {

	@Autowired
	private RedisComponent redisComponet;
	
	@Test
	public void sentinelSet(){
		User user = new User();
		user.setId("001");
		user.setAge("30");
		user.setName("wangpengfei");
		
		redisComponet.sentinelSet(user);
	}

	@Test
	public void sentinelGet(){
		String str = redisComponet.sentinelGet("001");
		System.out.println(str);
	}
}
