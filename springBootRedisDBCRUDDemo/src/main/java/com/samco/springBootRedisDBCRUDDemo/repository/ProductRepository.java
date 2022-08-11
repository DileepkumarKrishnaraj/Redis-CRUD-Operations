package com.samco.springBootRedisDBCRUDDemo.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.samco.springBootRedisDBCRUDDemo.entity.Product;

@Repository
public class ProductRepository {
	private HashOperations<Object, Object, Object> hashOperations;
	private RedisTemplate<Object, Object> redisTemplate;
	
	private static final String KEY = "PRODUCT";

	public ProductRepository(RedisTemplate<Object, Object> redisTemplate) {
		this.hashOperations = redisTemplate.opsForHash();
		this.redisTemplate = redisTemplate;
	}
	
	public void saveProduct(Product product) {
		hashOperations.put(KEY, product.getId(), product);
	}
	
	public List<Object> findAll(){
		return hashOperations.values(KEY);
	}
	
	public Product findById(Integer id) {
		return (Product)hashOperations.get(KEY, id);
	}
	
	public void update(Product product) {
		saveProduct(product);
	}
	
	public void delete(Integer id) {
		hashOperations.delete(KEY, id);
	}
}
