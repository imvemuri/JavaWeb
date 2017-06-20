package com.springapp;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

@Controller
public class LoginController {

	final static Logger LOGGER = Logger.getLogger(LoginController.class);
	
	//This is the default page after successful login
	public String showWelcome(ModelMap model){
		LOGGER.info("showWelcome() CALLED");
		model.put("name", "krish");
		return "welcome";
	}
}
