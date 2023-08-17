package com.otto.java6.service;

import java.util.List;

import com.otto.java6.entity.Product;

public interface ProductService {
	
	Product saveProduct(Product product);
	
	List<Product> getAllProduct();
	
	Product updateProduct(Product product, Long id);
	
	Product deleteProduct(Long id);
	
}
