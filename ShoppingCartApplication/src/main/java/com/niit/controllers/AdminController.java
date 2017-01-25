package com.niit.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


	@RequestMapping(value = {"/login","/userlogin"}, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam( required = false) String error, String denied,String logout) {
		
		 String message="";
		if (error != null) {
			message="Invalid username and password!";
			return new ModelAndView("error","message","message");
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
		System.out.println("logout");
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		  HttpSession session=request.getSession();  
          session.invalidate();  
	    return "redirect:index?logout";
	}
}
