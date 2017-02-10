package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemsDao;
import com.niit.domain.CartItems;
import com.niit.service.CartItemsService;
@Service

public class CartItemsServiceImp implements CartItemsService {
	@Autowired
	private CartItemsDao cartItemsDao;

	@Transactional
	public void add(CartItems cartItems) {
		cartItemsDao.add(cartItems);		
	}
	
	@Transactional
	public void edit(CartItems cartItems) {
		cartItemsDao.edit(cartItems);
		
	}

	@Transactional
	public List getAllCartitems() {
		return cartItemsDao.getAllCartitems();
	}

	@Transactional
	public void delete(int cartItems_id) {
		cartItemsDao.delete(cartItems_id);
		
	}

	@Transactional
	public CartItems getCartItems(int cartItems_id) {
		return cartItemsDao.getCartItems(cartItems_id);
	}

	@Transactional
	public List getAllProduct() {
		return cartItemsDao.getAllProduct();
	}

	@Transactional
	public CartItems getProductById(int id) {
		return cartItemsDao.getProductById(id);
	}

	@Transactional
	public List getbyname(String name) {
		return cartItemsDao.getbyname(name);
	}

	@Transactional
	public int cartLength() {
		return cartItemsDao.cartLength();
	}

	@Transactional
	public void update(CartItems cartItems) {
		cartItemsDao.update(cartItems);
		
	}

	

}
