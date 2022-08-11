package com.samco.springBootRedisDBCRUDDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samco.springBootRedisDBCRUDDemo.entity.Product;
import com.samco.springBootRedisDBCRUDDemo.repository.ProductRepository;

@RestController
@RequestMapping("")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/product")
	public Product saveProduct(@RequestBody Product product) {
		productRepository.saveProduct(product);
		return product;
	}
	
	@GetMapping("/product")
	public List<Object> findAll(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	public Product findById(@PathVariable("id") Integer id) {
		return productRepository.findById(id);
	}
	
	@PutMapping("/product/update/{id}")
	public void update(@RequestBody Product product) {
		productRepository.update(product);	
	}
	
	@DeleteMapping("/product/{id}")
	public void delete(@PathVariable("id") Integer id) {
		productRepository.delete(id);
	}

}
