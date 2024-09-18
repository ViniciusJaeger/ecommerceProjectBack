package com.alpdex.demo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpdex.demo.entity.Product;
import com.alpdex.demo.repository.ProductRepository;

@Service	
public class ProductBO {

	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	public List<Product> getAllProducts(){
		return this.productRepository.findAll();
	}
	
	public Product getProductById(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}
	
	public void deleteById(Long id) {
		this.productRepository.deleteById(id);
	}
}
