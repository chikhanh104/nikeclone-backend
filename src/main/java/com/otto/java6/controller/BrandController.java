package com.otto.java6.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.otto.java6.entity.Brand;
import com.otto.java6.service.BrandService;

@RestController
@RequestMapping("/api/v1/brands")
@CrossOrigin
public class BrandController {

    private final BrandService brandService;

    // Constructor injection of ProductService
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    //Create a new brand
    @PostMapping("/add")
    public ResponseEntity<String> addBrand(@RequestBody Brand brand) {
        brandService.saveBrand(brand);
        return ResponseEntity.status(HttpStatus.CREATED).body("New brand is added");
    }

    //Get all brands
    @GetMapping("/view")
    public ResponseEntity<List<Brand>> getAllBrands() {
        List<Brand> brands = brandService.getAllBrands();
        return ResponseEntity.ok(brands);
    }

    // Update brand by ID
    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@RequestBody Brand brand, @PathVariable Long id) {
        Brand updatedBrand = brandService.updateBrand(brand, id);
        if (updatedBrand != null) {
            return ResponseEntity.ok(updatedBrand);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Delete brand by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        if (brandService.deleteBrand(id) != null  ) {
			// Nếu xóa thành công, trả về mã trạng thái 204 No Content (không có dữ liệu trả về)
            return ResponseEntity.noContent().build();
        } else {
			// Nếu không tìm thấy thương hiệu hoặc xóa không thành công,
        // trả về mã trạng thái 404 Not Found (không có dữ liệu trả về)
            return ResponseEntity.notFound().build();
        }
    }
}