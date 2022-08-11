package com.samco.redisJedisCRUDOperations.repository;

import java.util.Map;

import com.samco.redisJedisCRUDOperations.model.Product;

public interface ProductRepository {
	
	void save(Product product);
	Map<String, Product> findAll();
	Product findById(String id);
	void update(Product product);
	void delete(String id);

}
