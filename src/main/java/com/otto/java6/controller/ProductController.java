package com.otto.java6.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otto.java6.entity.Product;
import com.otto.java6.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProduct();
	}

	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
		return productService.updateProduct(product, id);
	}

	@DeleteMapping("/{id}")
	public Product deleteProduct(@PathVariable Long id) {
		return productService.deleteProduct(id);
	}
}
