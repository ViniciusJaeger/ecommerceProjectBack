package com.alpdex.demo.vo;

import jakarta.validation.constraints.NotNull;

public class UpdateProductVO {

	@NotNull
	private Long id;
	
	private String name;

	private Double price;
	
	private Integer quantity;

	public UpdateProductVO() {
	}

	public UpdateProductVO(Long id, String name, Double price, Integer quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
