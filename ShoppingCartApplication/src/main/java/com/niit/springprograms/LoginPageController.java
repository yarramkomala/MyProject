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
	public String getRegister() {
//		dataService.insertRow(userinfo);
//		  return new ModelAndView("redirect:list");
		//@ModelAttribute UserInfo userinfo

		return "register";
	}
	
	@RequestMapping(value="/display",method=RequestMethod.POST)
	
	public ModelAndView getPage(@RequestParam("fname") String a,@RequestParam("lname") String b,@RequestParam("email") String c  ) {
      System.out.println("login");
      ModelAndView mv=new ModelAndView("login");
      mv.addObject("fname",a);
      mv.addObject("lname", b);
      mv.addObject("email", c);
		return mv;
	}
//	@RequestMapping("/validate")
//	public ModelAndView validate(@RequestParam("email") String email,@RequestParam("pwd")String pwd){
//		System.out.println("validate methode");
//		ModelAndView mv=new ModelAndView("user");
//		UserDao userDAO=new UserDao();
//		if(userDAO.isValidCredentials(email,pwd)==true){
//			mv.addObject("successmsg","you  logged in successfully");
////			
////		}
////		else{
////			mv.addObject("errormsg","please try again,");
////		}
////		return mv;
//	}
	
}

