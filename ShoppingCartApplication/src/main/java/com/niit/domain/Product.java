package com.niit.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//creating a table with name of Product
@Table(name="Product")
public class Product {
	
	@Id //which is used to give variable as primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//it gives u that the field should not be empty
	@NotEmpty(message="product name should not empty")
	private String productName;
	@NotNull
	private int price;
	@NotNull
	private int quantity;
	@NotEmpty(message="category name should not empty")
	private String categoryName;
	@NotEmpty(message="supplier name should not empty")
	private String supplierName;
	@Transient //keyword of java.
	private MultipartFile image;
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JsonIgnore
	 @JoinColumn(name="categoryid")
	private Category categoryid;
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	@NotEmpty(message="description name should not empty")
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public Category getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Category categoryid) {
		this.categoryid = categoryid;
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
