package com.niit.service;

import java.util.List;

import com.niit.domain.Product;

public interface ProductService {
	public void insertRow(Product product);

	 public List getProductList();

	 public Product getRowById(int id);

	 public void updateRow(Product product);

	 public void deleteRow(int id);
	 public List getAllProductfromCategory(String id);

}
