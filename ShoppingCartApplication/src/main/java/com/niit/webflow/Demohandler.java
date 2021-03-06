package com.niit.webflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.niit.domain.UserInfo;
import com.niit.domain.UserRoles;
import com.niit.service.UserService;
@Component
public class Demohandler {
	@Autowired
	UserService userservice;
	public UserInfo initFlow(){
		return new UserInfo();
	}
 
	public String validateDetails(UserInfo userinfo,MessageContext messageContext){
		String status = "success";
		if(userinfo.getUsername().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"username").defaultText("Username cannot be Empty").build());
			status = "failure";
		}
		if(userinfo.getPassword().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"password").defaultText("Password cannot be Empty").build());
			status = "failure";
		}
		if(userinfo.getFname().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"fname").defaultText("Firstname cannot be Empty").build());
			status = "failure";
		}
		if(userinfo.getLname().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"lname").defaultText("Lastname cannot be Empty").build());
			status = "failure";
		}
		if(userinfo.getAddress().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"address").defaultText("Address cannot be Empty").build());
			status = "failure";
		}
		if(userinfo.getContactnumber().isEmpty()){
			messageContext.addMessage(new MessageBuilder().error().source(
					"contactnumber").defaultText("ContactNumber cannot be Empty").build());
			status = "failure";
		}
		return status;
	}
	public String doregAction(UserInfo userinfo){
		UserRoles r=new UserRoles();
		r.setRole("ROLE_USER");
		r.setUserid(userinfo);
		userinfo.setEnabled(true);
		userservice.insertRow(userinfo);
		return "success";
	}

	
}
