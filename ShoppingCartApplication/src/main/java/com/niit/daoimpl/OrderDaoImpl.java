package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemsDao;
import com.niit.dao.OrderDao;
import com.niit.dao.UserDao;
import com.niit.domain.Cart;
import com.niit.domain.CartItems;
import com.niit.domain.Orders;
import com.niit.domain.Shippment;
import com.niit.domain.UserInfo;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	UserDao ud;

	@Override
	public void Cartitems() {
		sessionFactory.getCurrentSession().createSQLQuery("Truncate table CartItems").executeUpdate();
	}

	@Override
	public List getAllOrders() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Orders").list();
	}

	@Override
	@Transactional
	public void add(Cart carts) {
		UserInfo registrationDetails=new UserInfo();
		
		//set mailid in cart object
		/*registrationDetails.setUsername(username);
		carts.setId_fk(registrationDetails);*/
		
		//get list of product
		List<CartItems> li=cartItemsDao.getAllProduct();
		
		//to store the grand total
		int tot=0;
		for(int i=0;i<li.size();i++)
		{
			tot=(int) (tot+(li.get(i).getTotalPrice()));
		}
		
		//set the grand total in cart object
		carts.setTotal(tot);
		sessionFactory.getCurrentSession().save(carts);

	}

	@Override
	@Transactional
	public void orderadd(String username) {
		Orders orders=new Orders();
		Cart ct=new Cart();
		UserInfo registrationDetails=new UserInfo();
		
		//set the mail id in registration detail object and the pass it to orders object
		/*registrationDetails.setUsername(username);
		orders.setEmailid_fk(registrationDetails);*/
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String username1 = auth.getName();  
		 		 System.out.println(username);
		 List<UserInfo> userDetail = ud.getUserByName(username1);//user details are stored in userDetail object
		  System.out.println("It is entering into the billing address");
		 //TO STORE  THE USERID IN BILLINGADDRESS TABLE
		   for(int i=0;i<userDetail .size();i++)
		   { 
		    System.out.println("It is entering into block which is to add user id");
			orders.setEmailid_fk(userDetail.get(i));
			
		   }
		
		//get list of product in cart based on mailid
		@SuppressWarnings("unchecked")
		List<Cart> ca=sessionFactory.getCurrentSession().createQuery("from Cart where id_fk='"+username+"'").list();
		/*ct.setCartId(ca.get(0).getCartId());*/
		orders.setCartid_fk(ct);
		
		//get list of product in shipment based on mailid and store the latest one
		@SuppressWarnings("unchecked")
		List<Shippment> shr=sessionFactory.getCurrentSession().createQuery("from Shippment where userid='"+username+"'").list();
		orders.setSid_fk(shr.get(shr.size()-1));
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(orders);
		
		//get the username and set the latest cartid in the customer table
		ud.getUserByName(username);
		List<UserInfo> rs=ud.getUserByName(username);
		registrationDetails=rs.get(0);
		registrationDetails.setCart(ca.get(ca.size()-1));
		ud.edit(registrationDetails);
		

	}

}
