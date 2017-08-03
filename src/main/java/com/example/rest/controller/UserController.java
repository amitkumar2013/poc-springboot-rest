package com.example.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.model.User;
import com.example.rest.model.UserNotFoundException;
import com.example.rest.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping
	String home() {
		logger.info("Works just fine");
		return "Hi! from User Service! ";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	User getUserAsJson(@PathVariable("id") int id) {
		logger.info("GET and JSON combo");
		User user = userService.getUser(id);
		if (user == null) {
			throw new UserNotFoundException("No such user exists for id " + id);
		}
		return user;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/xml")
	User getUserAsXML(@PathVariable("id") int id) {
		logger.info("GET and XML combo");
		User user = userService.getUser(id);
		if (user == null) {
			throw new UserNotFoundException("No such user exists for id " + id);
		}
		return user;
	}

	@RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/json")
	User getUserAsJsonWithQueryParam(@RequestParam("id") int id) {
		logger.info("GET with Query Param and Json combo");
		User user = userService.getUser(id);
		if (user == null) {
			throw new UserNotFoundException("No such user exists for id " + id);
		}
		return user;
	}

	@RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/xml")
	User getUserAsXMLWithQueryParam(@RequestParam("id") int id) {
		logger.info("GET with Query Param and XML combo");
		User user = userService.getUser(id);
		if (user == null) {
			throw new UserNotFoundException("No such user exists for id " + id);
		}
		return user;
	}

	@RequestMapping("/validheader")
	String validateUser(@RequestHeader("variableX") String xValue) {
		if (xValue == null || xValue.isEmpty()) {
			return "Header = " + null;
		}
		return "Header = " + xValue;
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	User createUserAsJson(@RequestBody User user) {
		logger.info("POST and JSON combo");
		return userService.createUser(user);
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/xml", consumes = "application/xml")
	User createUserAsXML(@RequestBody User user) {
		logger.info("POST and XML combo");
		return userService.createUser(user);
	}
}
