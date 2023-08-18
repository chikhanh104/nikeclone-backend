package com.otto.java6.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.otto.java6.entity.Brand;
import com.otto.java6.repository.BrandRepository;
import com.otto.java6.service.BrandService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {


	private  final BrandRepository brandRepository;

	@Override
	public Brand saveBrand(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public List<Brand> getAllBrands() {
		return brandRepository.findAll();
	}

	@Override
	public Brand updateBrand(Brand brand, Long id) {
		Optional<Brand> existingBrand = brandRepository.findById(id);
		if (existingBrand.isPresent()) {
			Brand updatedBrand = existingBrand.get();
			updatedBrand.setBrandname(brand.getBrandname());
			return brandRepository.save(updatedBrand);
		}
		return null;
	}

	@Override
	public Brand deleteBrand(Long id) {
		Optional<Brand> brand = brandRepository.findById(id);
		if (brand.isPresent()) {
			brandRepository.deleteById(id);
			return brand.get();
		}
		return null;
	}

	@Override
	public Brand getBrandById(Long id) {
		// TODO Auto-generated method stub
		Optional<Brand> optionalBrand = brandRepository.findById(id);
        return optionalBrand.orElse(null);
	}
}
