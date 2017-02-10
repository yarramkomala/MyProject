package com.niit.serviceimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartDao;
import com.niit.domain.Cart;
import com.niit.domain.UserInfo;
import com.niit.service.CartService;
@Service

public class CartServiceImp implements CartService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	SessionFactory session;

	@Transactional
	public void add(Cart cart) {
		cartDao.add(cart);
		
	}
	@Transactional
	public void delete(int cartId) {
		cartDao.delete(cartId);
		
	}


	@Transactional
	public Cart getCart(int cartId) {
		return cartDao.getCart(cartId);
	}

	@Transactional
	public List getAllCart() {
		return cartDao.getAllCart();
	}
	@Transactional
	public List getbyuserid(int id)
	{
		String Query="from CartItems where userid='"+id+"'";
		
		@SuppressWarnings("unchecked")
		List<UserInfo> crtitem = session.getCurrentSession().createQuery(Query).list();
		return crtitem;
	}
	
}
