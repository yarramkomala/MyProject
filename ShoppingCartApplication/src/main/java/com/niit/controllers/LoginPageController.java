package com.niit.controllers;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.domain.UserInfo;
import com.niit.service.UserService;;

@Controller
public class LoginPageController {
	@Autowired
	UserService userservice;
	@RequestMapping("/")
	public String getHome() {

		return "index";
	}
	@RequestMapping("/uhome")
	public String getindex() {

		return "index";
	}
/*	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin");
	  return model;

	}

	@RequestMapping("/login")
	
		public ModelAndView login(@RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout) {

			  ModelAndView model = new ModelAndView();
			  if (error != null) {
				model.addObject("error", "Invalid username and password!");
			  }

			  if (logout != null) {
				model.addObject("msg", "You've been logged out successfully.");
			  }
			  model.setViewName("login");

			  return model;

			}
	//for 403 access denied page
		@RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView accesssDenied() {

		  ModelAndView model = new ModelAndView();

		  //check if user is login
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		  if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		  }

		  model.setViewName("403");
		  return model;

		}*/
		
	@RequestMapping("/register")
	public String getRegister(Map<String,Object> map) {
	UserInfo userinfo=new UserInfo();
	map.put("userinfo", userinfo);
	
	System.out.println(userinfo);
		
		return "register";
	}
	@RequestMapping("/register.do")
	public String doAction(@ModelAttribute UserInfo userinfo,BindingResult result,@RequestParam String action,Map<String,Object> map){
		
	UserInfo userlist=new UserInfo();
	switch(action.toLowerCase()){
	case "add":
		userservice.insertRow(userinfo);
		userlist=userinfo;
		break;
	}
		map.put("userinfo",userlist);
		
		return "index";
	}
	
}

