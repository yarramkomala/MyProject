package com.niit.springprograms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.domain.UserInfo;
import com.niit.uaerDao.UserDao;;

@Controller
public class LoginPageController {
	@RequestMapping("/")
	public String getHome() {

		return "index";
	}
	@RequestMapping("/login")
	public String getLogin() {

		return "login";
	}
	@RequestMapping("/register")
	public String getRegister(@ModelAttribute UserInfo userinfo) {

		dataService.insertRow(userinfo);
		  return new ModelAndView("redirect:list");
		
		return "register";
	}
	
	
	
}

