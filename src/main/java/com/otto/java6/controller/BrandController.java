package com.otto.java6.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otto.java6.entity.Brand;
import com.otto.java6.service.BrandService;

@RestController
@RequestMapping("/api/v1/brands")
@CrossOrigin
public class BrandController {

	private final BrandService brandService;

	public BrandController(BrandService brandService) {
		this.brandService = brandService;
	}

	@PostMapping(value = "add")
	public String add(@RequestBody Brand brand) {
		 brandService.saveBrand(brand);
		 return "New brand is added";
	}

	@GetMapping
	public List<Brand> getAllBrands() {
		return brandService.getAllBrands();
	}

	@PutMapping("/{id}")
	public Brand updateBrand(@RequestBody Brand brand, @PathVariable Long id) {
		return brandService.updateBrand(brand, id);
	}

	@DeleteMapping("/{id}")
	public Brand deleteBrand(@PathVariable Long id) {
		return brandService.deleteBrand(id);
	}
}