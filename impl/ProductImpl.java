package com.alpdex.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpdex.demo.bo.ProductBO;
import com.alpdex.demo.entity.Product;
import com.alpdex.demo.service.ProductService;
import com.alpdex.demo.vo.ProductVO;
import com.alpdex.demo.vo.UpdateProductVO;

@Service
public class ProductImpl implements ProductService {
	
	@Autowired
	ProductBO productBO;
	
	@Override
	public Product saveProduct(ProductVO productVO) {
		Product product = new Product();
		
		product.setName(productVO.getName());
		product.setPrice(productVO.getPrice());
		product.setQuantity(productVO.getQuantity());
		
		return this.productBO.saveProduct(product);
	}
	
	@Override
	public List<Product> getAllProducts(){
		return this.productBO.getAllProducts();
	}
	
	@Override
	public Product getProductById(Long id) {
		return this.productBO.getProductById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		this.productBO.deleteById(id);
	}
	
	@Override
	public Product updateProduct(Long id, UpdateProductVO updateProductVO) {
		Product product = new Product();
		
		product = this.productBO.getProductById(id);
		
		if(updateProductVO.getName() != null) {
			product.setName(updateProductVO.getName()); 
		}
		
		if(updateProductVO.getPrice() != null) {
			product.setPrice(updateProductVO.getPrice());
		}
		
		if(updateProductVO.getQuantity() != null) {
			product.setQuantity(updateProductVO.getQuantity());
		}
		
		return this.productBO.saveProduct(product);
	}
}
