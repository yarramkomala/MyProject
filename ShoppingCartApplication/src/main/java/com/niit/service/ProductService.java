package com.niit.service;

import java.util.List;

import com.niit.domain.Product;

public interface ProductService {
	public int insertRow(Product product);

	 public List getProductList();

	 public Product getRowById(int id);

	 public int updateRow(Product product);

	 public int deleteRow(int id);

}
