package com.otto.java6.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "product_price")
	private Double productPrice;

	@Column(name = "product_image")
	private String productImage;

	@Column(name = "update_date")
	private LocalDateTime updateDate;

	@Column(name = "active")
	private Boolean active = false;

	@Column(name = "product_type")
	private String productType;

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String productName, String productDescription, Double productPrice, String productImage,
			LocalDateTime updateDate, Boolean active, String productType, Brand brand) {
		super();
		this.id = id;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.updateDate = updateDate;
		this.active = active;
		this.productType = productType;
		this.brand = brand;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime localDateTime) {
		this.updateDate = localDateTime;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}
