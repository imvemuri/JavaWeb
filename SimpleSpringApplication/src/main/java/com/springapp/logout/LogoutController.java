package com.springapp.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	
	final static Logger LOGGER = Logger.getLogger(LogoutController.class);

	// Invalidate the session and redirect him to base Login page.
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String updatedTarget(HttpServletRequest req,HttpServletResponse resp){
		LOGGER.info("updatedTarget()");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			new SecurityContextLogoutHandler().logout(req,resp,auth);
			req.getSession().invalidate();
		}
		return "redirect:/";
	}
	
	
}
