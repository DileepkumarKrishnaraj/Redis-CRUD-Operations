package com.samco.redisJedisCRUDOperations.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.samco.redisJedisCRUDOperations.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	private RedisTemplate<String, Product> redisTemplate;
	
	private HashOperations<String, String, Product> hashOperations;
	
	public ProductRepositoryImpl(RedisTemplate<String, Product> redisTemplate) {
		this.redisTemplate = redisTemplate;
		
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(Product product) {
		hashOperations.put("PRODUCT", product.getId(), product);
	}

	@Override
	public Map<String, Product> findAll() {
		return hashOperations.entries("PRODUCT");
	}

	@Override
	public Product findById(String id) {
		return (Product)hashOperations.get("PRODUCT", id);
	}

	@Override
	public void update(Product product) {
		save(product);

	}

	@Override
	public void delete(String id) {
		hashOperations.delete("PRODUCT", id);

	}

}
