package com.alpdex.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alpdex.demo.entity.Product;
import com.alpdex.demo.service.ProductService;
import com.alpdex.demo.vo.ProductVO;
import com.alpdex.demo.vo.UpdateProductVO;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	@Transactional
	@ResponseStatus(code=HttpStatus.CREATED)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Product> saveProduct(@RequestBody ProductVO productVO) {
		Product savedProduct = this.productService.saveProduct(productVO);	
		 return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}

	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = this.productService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	@Transactional
	public ResponseEntity<Product> atualizar(@PathVariable Long id, @RequestBody UpdateProductVO dados) {
		Product product = this.productService.updateProduct(id, dados);
		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Product foundProduct = this.productService.getProductById(id);
		return new ResponseEntity<>(foundProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		this.productService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
