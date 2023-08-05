package com.otto.java6.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
	private String updateDate;

	@Column(name = "active")
	private Boolean active = false;

	@Column(name = "product_type")
	private String productType;

	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brand;
}
