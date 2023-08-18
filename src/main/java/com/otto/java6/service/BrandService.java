package com.otto.java6.service;

import java.util.List;

import com.otto.java6.entity.Brand;

public interface BrandService {
	Brand saveBrand(Brand brand);

	List<Brand> getAllBrands();

	Brand updateBrand(Brand brand, Long id);

	Brand deleteBrand(Long id);

	Brand getBrandById(Long id);
	
}
