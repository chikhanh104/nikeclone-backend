package com.otto.java6.service;

import java.util.List;

import com.otto.java6.entity.Product;

public interface ProductService {
	
	Product SAVEPRODUCT(Product product);
	
	List<Product> GETALLPRODUCT();
	
	Product UPDATEPRODUCT(Product product, Long id);
	
	Product DELETEPRODUCT(Long id);
	
}
