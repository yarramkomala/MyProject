package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ProductDao;
import com.niit.domain.Product;
import com.niit.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;
	
	@Override
	public void insertRow(Product product) {
		
		 productDao.insertRow(product);
	}

	@Override
	public List getProductList() {
		
		return productDao.getProductList();
	}

	@Override
	public Product getRowById(int id) {
		
		return productDao.getRowById(id);
	}

	@Override
	public void updateRow(Product product) {
		
	 productDao.updateRow(product);
	}

	@Override
	public void deleteRow(int id) {
		
		 productDao.deleteRow(id);
	}

	@Override
	public List getAllProductfromCategory(String id) {

		return productDao.getAllProductfromCategory(id);
	}
	

}
