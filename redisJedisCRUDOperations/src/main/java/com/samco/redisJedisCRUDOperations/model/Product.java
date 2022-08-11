package com.samco.redisJedisCRUDOperations.model;

import java.io.Serializable;

public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private Long amount;
	
	public Product(String id, String name, Long amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
