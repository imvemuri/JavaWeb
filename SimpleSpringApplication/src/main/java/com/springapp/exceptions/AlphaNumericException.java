package com.springapp.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Converts exceptions to HTTP Status codes.
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason="Alpha Numeric description")
public class AlphaNumericException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	final static Logger LOGGER = Logger.getLogger(AlphaNumericException.class);

	
	public AlphaNumericException(String desc){
		super("Please Enter valid description");
	}
}
