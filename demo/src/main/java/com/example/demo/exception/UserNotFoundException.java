package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*This annotation is to send the correct HTTP status code for that Exception
Eg. Here is Exception of User not found so the status code should go as 404 error
butIf we do not add this attribute and HttpStatus Code , 
It will give us 500 i.e. internal server Error*/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String string) {
		super(string);
	}
}
