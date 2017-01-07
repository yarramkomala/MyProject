package com.niit.controllers;
import java.util.List;
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
	@RequestMapping("/login")
	public String getLogin() {

		return "login";
	}
	@RequestMapping("/register")
	public String getRegister(Map<String,Object> map) {
	UserInfo userinfo=new UserInfo();
	map.put("userinfo", userinfo);
	map.put("userlist",userservice.getList());
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
	case "update":
		userservice.updateRow(userinfo);
		userlist=userinfo;
		break;
	case "delete":
		userservice.deleteRow(userinfo.getUsername());
		userlist=new UserInfo();
		break;
	
	}
		map.put("userinfo",userlist);
		map.put("userlist",userservice.getList());
		return "index";
	}
	
	@RequestMapping("list")
	 public ModelAndView getList(@ModelAttribute UserInfo userinfo,BindingResult result ,Map<Object, String> map ){
		List userlist=userservice.getList();
		return new ModelAndView("list","userlist",userlist);
		
	}
	
}

