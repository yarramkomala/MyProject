package com.niit.webflow;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.niit.dao.UserDao;
import com.niit.domain.Shippment;
import com.niit.domain.UserInfo;
import com.niit.service.ShippmentService;
import com.niit.service.UserService;
@Component
public class Shippmenthandler {
	
	@Autowired
	private ShippmentService shippmentService;
	@Autowired
	UserService us;
	@Autowired
	HttpServletRequest req;
	@Autowired
	UserDao userdao;
	
	public Shippment initFlow() {
		return new Shippment();
	}

	public String validateDetails(Shippment shippment, MessageContext messageContext) {
		String status = "success";
		if (shippment.getName().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("name").defaultText("Name cannot be Empty").build());
			status = "failure";
		}
		if (shippment.getAddress().isEmpty()) {
			messageContext.addMessage(
					new MessageBuilder().error().source("address").defaultText("Address cannot be Empty").build());
			status = "failure";
		}
		if (shippment.getCity().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("city")
					.defaultText("City cannot be Empty").build());
			status = "failure";
		}
		if (shippment.getState().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("state")
					.defaultText("State cannot be Empty").build());
			status = "failure";
		}
		if (shippment.getPincode().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("pincode")
					.defaultText("Pincode cannot be Empty").build());
			status = "failure";
		}
		if (shippment.getMobilenumber().isEmpty()) {
			messageContext.addMessage(new MessageBuilder().error().source("mobilenumber")
					.defaultText("Mobile Number cannot be Empty").build());
			status = "failure";
		}
		
		
		return status;
	}
	public String ship(Shippment shippment){
		 /*String username;
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
	      HttpSession ses=req.getSession();
	     ses.setAttribute("u", name);
	      username=(String)ses.getAttribute("u");
	      UserInfo userinfo=new UserInfo();
	      userinfo.setUsername(username);
		shippment.setUsername(userinfo);
		int id=shippment.getSid();*/
		System.out.println("It is entering into the billing address");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String username = auth.getName();  
		 		 System.out.println(username);
		 List<UserInfo> userDetail = userdao.getUserByName(username);//user details are stored in userDetail object
		  System.out.println("It is entering into the billing address");
		 //TO STORE  THE USERID IN BILLINGADDRESS TABLE
		   for(int i=0;i<userDetail .size();i++)
		   { 
		    System.out.println("It is entering into block which is to add user id");
			shippment.setUsername(userDetail.get(i));
			
		   }
		shippmentService.add(shippment);
		
		return "success";
	}

}
