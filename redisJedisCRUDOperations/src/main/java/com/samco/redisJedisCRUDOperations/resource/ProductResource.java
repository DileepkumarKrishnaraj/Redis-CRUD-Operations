package com.samco.redisJedisCRUDOperations.resource;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samco.redisJedisCRUDOperations.model.Product;
import com.samco.redisJedisCRUDOperations.repository.ProductRepository;

@RestController
@RequestMapping("/rest/product")
public class ProductResource {
	
	private ProductRepository productRepository;
	
	public ProductResource(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping("/add/{id}/{name}")
	public Product add(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		productRepository.save(new Product(id, name, 20000L));
		return productRepository.findById(id);
	}
	
	/*
	 * @GetMapping("/update/{id}/{name}") public Product update(@PathVariable("id")
	 * final String id, @PathVariable("name") final String name) {
	 * productRepository.update(new Product(id, name, 1000L)); return
	 * productRepository.findById(id); }
	 * 
	 * @GetMapping("/all") public Map<String, Product> update() { return
	 * productRepository.findAll(); }
	 */

}
