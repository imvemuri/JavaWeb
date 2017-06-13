package com.simplewebapp;

// Validates Login details
public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		if (user.equals("krish") && password.equals("4477"))
			return true;

		return false;
	}
}
