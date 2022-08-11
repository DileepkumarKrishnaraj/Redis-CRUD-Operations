package com.samco.springBootRedisDBCRUDDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class SpringBootRedisDbcrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRedisDbcrudDemoApplication.class, args);    
		
	}
	
	@Bean
	LettuceConnectionFactory lettuceConnectionFactory() {
		return new LettuceConnectionFactory();
	}
	
	@Bean
	RedisTemplate<Object,Object> redisTemplate() {
		RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object,Object>();
		redisTemplate.setConnectionFactory(lettuceConnectionFactory());
		return redisTemplate;
	}

}
