package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemsDao;
import com.niit.domain.CartItems;
@Repository
public class CartItemsDaoImp implements CartItemsDao {
	@Autowired
	private SessionFactory session;

	@Transactional(propagation = Propagation.SUPPORTS)
	public void add(CartItems cartItems) {
		session.getCurrentSession().save(cartItems);
		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void edit(CartItems cartItems) {
		session.getCurrentSession().update(cartItems);
		
	}


	@Transactional(propagation = Propagation.SUPPORTS)
	public List getAllCartitems() {
		return session.getCurrentSession().createQuery("from CartItems ").list();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(int cartItems_id) {
		session.getCurrentSession().delete(getCartItems(cartItems_id));
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public CartItems getCartItems(int cartItems_id) {
		return (CartItems)session.getCurrentSession().get(CartItems.class, cartItems_id);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List getAllProduct() {
		return session.getCurrentSession().createQuery("from CartItems ").list();

	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public CartItems getProductById(int id) {
		return (CartItems)session.getCurrentSession().get(CartItems.class, id);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List getbyname(String name) {
		return session	.getCurrentSession().createQuery("from Cart where username ='"+name+"'").list();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public int cartLength() {
		List cartitems=session.getCurrentSession().createQuery("from CartItems ").list();
		return cartitems.size();
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void update(CartItems cartItems) {
		session.getCurrentSession().update(cartItems);
		
	}

	
		
	}

	

