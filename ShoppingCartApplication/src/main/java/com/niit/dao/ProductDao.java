package com.niit.dao;

import java.util.List;

import com.niit.domain.Product;
//interface
public interface ProductDao {
	
	public void insertRow(Product product);

	public Product getRowById(int id);

	public void updateRow(Product product);

	public void deleteRow(int id);

	public List getProductList();
	public List getAllProductfromCategory(String id);

	Product getProduct(int id);

}
