package com.niit.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AdminController {
String error=null;
//	@RequestMapping(value = {"/welcome" }, method = RequestMethod.GET)
//	public ModelAndView defaultPage() {
//
//		ModelAndView model = new ModelAndView();
//	
//		model.addObject("title", "Spring Security Login Form - Database Authentication");
//		model.addObject("message", "This is default page!");
//		model.addObject("role","ROLE_ADMIN");
//		model.setViewName("security/hello");
//		//call a method ROLE
//		
//		return model;
//
//	}

//	@RequestMapping(value = "/admin", method = RequestMethod.GET)
//	public ModelAndView adminPage() {
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Login Form - Database Authentication");
//		model.addObject("message", "This page is for ROLE_ADMIN only!");
//		model.setViewName("security/admin");
//
//		return model;
//
//	}

	@RequestMapping(value = {"/login","/userlogin"}, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam( required = false) String error, String denied,String logout) {
		
		 String message="";
		if (error != null) {
			message="Invalid username and password!";
			return new ModelAndView("403","message","message");
		}
		else if(denied!=null){
			message="access denied for thisage";
			return new ModelAndView("403", "message","message");
		}

		if (logout != null) {
			message="You've been logged out successfully.";
			return new ModelAndView("index","message","message");
		}
		

		return new ModelAndView("login","message","message");

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied() {

		return "403";

	}
	@RequestMapping("/logout")
	public String showLoggedout(HttpServletRequest request,HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
	    return "redirect:index?logout";
	}
}
