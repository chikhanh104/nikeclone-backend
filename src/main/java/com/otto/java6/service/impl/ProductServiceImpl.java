package com.otto.java6.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.otto.java6.entity.Product;
import com.otto.java6.repository.ProductRepository;
import com.otto.java6.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		// TODO Auto-generated method stub
		Optional<Product> existingProduct = productRepository.findById(id);
		if (existingProduct.isPresent()) {
			Product updateProduct = existingProduct.get();
			updateProduct.setProductName(product.getProductName());
			updateProduct.setProductPrice(product.getProductPrice());
			updateProduct.setProductImage(product.getProductImage());
			updateProduct.setProductDescription(product.getProductDescription());
			updateProduct.setUpdateDate(LocalDateTime.now());
			return productRepository.save(updateProduct);
		}
		return null;
	}

	@Override
	public Product deleteProduct(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			productRepository.deleteById(id);
			return product.get();
		}
		return null;
	}

}
