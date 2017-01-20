package com.niit.controllers;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	 @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String adminPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "admin";
//	@RequestMapping("/login")
//	
//		public ModelAndView login(@ModelAttribute UserInfo userinfo,@RequestParam("pwd") String pwd,@RequestParam("email") String email) {
//
//			  ModelAndView model = new ModelAndView("login");
////			  userservice.
////			  if (error != null) {
////				model.addObject("error", "Invalid username and password!");
////			  }
////
////			  if (logout != null) {
////				model.addObject("msg", "You've been logged out successfully.");
////			  }
//			if(userinfo.getUsername()==email && userinfo.getPassword()==pwd){
//				 return model;
//			}
//
//			  return model;
//
//			}
	
		
	@RequestMapping("/register")
	public String getRegister(Map<String,Object> map) {
	UserInfo userinfo=new UserInfo();
	map.put("userinfo", userinfo);
	
	System.out.println(userinfo);
		
		return "register";
	}
	@RequestMapping("/register.do")
	public String doAction(@ModelAttribute UserInfo userinfo,BindingResult result,@RequestParam String action,Map<String,Object> map){
		

		userservice.insertRow(userinfo);
		
		return "login";
	}
	
}

