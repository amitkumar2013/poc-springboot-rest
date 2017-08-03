package com.example.rest.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "Department Already exists")
public class DeptAlreadyException extends RuntimeException {

	String message;

	public DeptAlreadyException(String msg) {
		this.message = msg;
	}

	private static final long serialVersionUID = 1L;

}
