package com.alpdex.demo.service;

import java.util.List;

import com.alpdex.demo.entity.Product;
import com.alpdex.demo.vo.ProductVO;
import com.alpdex.demo.vo.UpdateProductVO;


public interface ProductService {
	
	public Product saveProduct(ProductVO productVo);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long id);
	
	public void deleteById(Long id);
	
	public Product updateProduct(Long id, UpdateProductVO updateProductVO);
}
