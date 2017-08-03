package com.example.rest.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "User Already exists")
public class UserAlreadyException extends RuntimeException {

	String message;

	public UserAlreadyException(String msg) {
		this.message = msg;
	}

	private static final long serialVersionUID = 1L;

}
