package com.alpdex.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="product")
@Entity(name="Product")
public class Product {

	@Column(name="ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="QUANTITY")
	private Integer quantity;
	
	@Column(name="REGISTER_DATE")
	private LocalDate registerDate = LocalDate.now();
	
	@Column(name="ACTIVE_PRODUCT")
	private boolean active = true;
	
	public Product() {
	}
	
	public Product(Long id, String name, Double price, Integer quantity, LocalDate registerDate) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.registerDate = registerDate;
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

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
