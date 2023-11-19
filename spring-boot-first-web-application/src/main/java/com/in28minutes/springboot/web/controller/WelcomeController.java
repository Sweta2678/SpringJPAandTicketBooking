package com.in28minutes.springboot.web.controller;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
//@SessionAttributes("name")
public class WelcomeController {

	// Model
//	@RequestMapping("/login")
//	public String loginMessage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		return "login";
//	}
//	@RequestMapping("/login/{name}")
//	public String loginMessage(@PathVariable String name, ModelMap model) {
//		model.put("name", name);
//		return "login";
//	}
//	@RequestMapping(value="/login/{name}", method = RequestMethod.POST)
//	public String showWelcomePage(ModelMap model, @RequestParam String name){
//		model.put("name", name);
//		return "welcome";
//	}
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String showWelcomePage(ModelMap model) {
			model.put("name", getLoggedinUserName());
			return "welcome";
		}

		private String getLoggedinUserName() {
			Object principal = SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			
			if (principal instanceof UserDetails) {
				return ((UserDetails) principal).getUsername();
			}
			return principal.toString();
		}
	}
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String showLoginPage(ModelMap model) {
//		model.put("name", "in28Minutes");
//		return "welcome";
//	}
	
//	@RequestMapping(value="/login", method = RequestMethod.GET)
//	public String showLoginPage(ModelMap model){
//		return "login";
//	}
	
//	@RequestMapping(value="/login", method = RequestMethod.POST)
//	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
//		boolean isValidUser = service.validateUser(name, password);
//		
//		if (!isValidUser) {
//			model.put("errorMessage", "Invalid Credentials");
//			return "login";
//		}
//		
//		model.put("name", name);
//		model.put("password", password);
//		
//		return "welcome";
//	}

