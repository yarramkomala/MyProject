package com.niit.dao;

import java.util.List;

import com.niit.domain.Product;
//interface
public interface ProductDao {
	
	public int insertRow(Product product);

	public Product getRowById(int id);

	public int updateRow(Product product);

	public int deleteRow(int id);

	public List getProductList();

}
