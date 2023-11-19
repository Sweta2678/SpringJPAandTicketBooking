package com.cignex.ticketBooking.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("sweta")
				&& password.equalsIgnoreCase("sweta");
	}
	
public boolean validateUser1(String name, String password) {
		
		return name.equalsIgnoreCase("sweta")
				&&password.equalsIgnoreCase("sweta@");
	}

}
