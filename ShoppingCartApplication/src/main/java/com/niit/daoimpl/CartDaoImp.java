package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartDao;
import com.niit.domain.Cart;
import com.niit.domain.UserInfo;
@Repository
public class CartDaoImp implements CartDao {
	@Autowired
	private SessionFactory session;

	@Transactional(propagation = Propagation.SUPPORTS)
	public void add(Cart cart) {
		session.getCurrentSession().save(cart);
		
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(int cartId) {
		session.getCurrentSession().delete(getCart(cartId));
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Cart getCart(int cartId) {
		return (Cart)session.getCurrentSession().get(Cart.class, cartId);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List getAllCart() {
		return session.getCurrentSession().createQuery("from Cart").list();
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
