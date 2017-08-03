package com.example.rest.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "Org Already exists")
public class OrgAlreadyException extends RuntimeException {

	String message;

	public OrgAlreadyException(String msg) {
		this.message = msg;
	}

	private static final long serialVersionUID = 1L;

}
