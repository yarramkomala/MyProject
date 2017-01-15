package com.niit.controllers;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping("home")
	public String getindex() {

		return "index";
	}
	@RequestMapping("/login")
	public String getLogin() {

		return "login";
	}
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

