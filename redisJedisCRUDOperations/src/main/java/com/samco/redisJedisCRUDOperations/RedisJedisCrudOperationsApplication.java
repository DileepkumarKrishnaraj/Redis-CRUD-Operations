package com.samco.redisJedisCRUDOperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.samco.redisJedisCRUDOperations.model.Product;

@SpringBootApplication
public class RedisJedisCrudOperationsApplication {
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean 
	RedisTemplate<String, Product> redisTemplate() {
		RedisTemplate<String, Product> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisJedisCrudOperationsApplication.class, args);
	}

}
