package com.example.rest.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "To show an example of a custom message")
public class UserNotFoundException extends RuntimeException {

	String message;

	public UserNotFoundException(String msg) {
		this.message = msg;
	}

	private static final long serialVersionUID = 1L;

}
