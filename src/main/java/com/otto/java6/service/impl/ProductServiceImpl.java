package com.otto.java6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otto.java6.entity.Product;
import com.otto.java6.repository.ProductRepository;
import com.otto.java6.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product SAVEPRODUCT(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> GETALLPRODUCT() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product UPDATEPRODUCT(Product product, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product DELETEPRODUCT(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
