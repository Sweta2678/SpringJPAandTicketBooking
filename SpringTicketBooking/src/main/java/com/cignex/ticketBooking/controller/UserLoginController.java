package com.cignex.ticketBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cignex.ticketBooking.service.LoginService;



@Controller
public class UserLoginController {

	@Autowired
	LoginService service;

	@RequestMapping(value="/user-login", method = RequestMethod.GET) // this is to get the login page
	public String showLoginPage(ModelMap model){
		return "/userlogin";
	
}
	
	@RequestMapping(value="/user-login", method = RequestMethod.POST)
	public String showUserWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
		boolean isValidUser = service.validateUser1(name, password);
	
		if (!isValidUser) {
			model.put("errorMessage", "Invalid Credentials");
			return "/userlogin";
		}
		
		model.put("name", name);
		model.put("password", password);
		
	     return "/userwelcome";
}
	
}
