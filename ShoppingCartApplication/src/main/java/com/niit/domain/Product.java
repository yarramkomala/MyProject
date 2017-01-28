package com.niit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
//creating a table with name of Product
@Table(name="Product")
public class Product {
	
	@Id//which is used to give variable as primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//it gives u that the field should not be empty
	@NotEmpty(message="product name should not null")
	private String productName;
	@NotEmpty(message="productname should not be null")
	private String price;
	@NotEmpty(message="quantity should not be null")
	private String quantity;
	@NotEmpty(message="category name should not null")
	private String categoryName;
	@NotEmpty(message="supplier name should not null")
	private String supplierName;
	@Transient //keyword of java.
	private MultipartFile image;
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getproductName() {
		return productName;
	}
	public void setproductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
}
