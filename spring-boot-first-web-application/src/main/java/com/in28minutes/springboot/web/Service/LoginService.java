package com.in28minutes.springboot.web.Service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userid, String password) {
		return userid.equalsIgnoreCase("in28minutes")
				&& password.equalsIgnoreCase("dummy");
	}

}
