package com.springapp.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
	final static Logger LOGGER = Logger.getLogger(ExceptionController.class);
	
	// A Global Controller for entire application.Returns error.jsp page
	@ExceptionHandler(Exception.class)
	public String handleError(HttpServletRequest req, Exception ex) {
		LOGGER.error("Request: " + req.getRequestURL() + " raised " + ex);
	    return "error";
	}
	
}
