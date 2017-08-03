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

import com.example.rest.model.Department;
import com.example.rest.model.DeptNotFoundException;
import com.example.rest.service.DeptService;

@RestController
@RequestMapping(value = "/dept")
public class DeptController {

	private static Logger logger = LoggerFactory.getLogger(DeptController.class);

	@Autowired
	private DeptService deptService;

	@RequestMapping
	String home() {
		logger.info("Works just fine");
		return "Hi! from Dept Service! ";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	Department getDeptAsJson(@PathVariable("id") int id) {
		logger.info("GET and JSON combo");
		Department dept = deptService.getDepartment(id);
		if (dept == null) {
			throw new DeptNotFoundException("No such dept exists for id " + id);
		}
		return dept;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/xml")
	Department getDeptAsXML(@PathVariable("id") int id) {
		logger.info("GET and XML combo");
		Department dept = deptService.getDepartment(id);
		if (dept == null) {
			throw new DeptNotFoundException("No such dept exists for id " + id);
		}
		return dept;
	}

	@RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/json")
	Department getDeptAsJsonWithQueryParam(@RequestParam("id") int id) {
		logger.info("GET with Query Param and Json combo");
		Department dept = deptService.getDepartment(id);
		if (dept == null) {
			throw new DeptNotFoundException("No such dept exists for id " + id);
		}
		return dept;
	}

	@RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/xml")
	Department getDeptAsXMLWithQueryParam(@RequestParam("id") int id) {
		logger.info("GET with Query Param and XML combo");
		Department dept = deptService.getDepartment(id);
		if (dept == null) {
			throw new DeptNotFoundException("No such dept exists for id " + id);
		}
		return dept;
	}

	@RequestMapping("/validheader")
	String validateDept(@RequestHeader("variableX") String xValue) {
		if (xValue == null || xValue.isEmpty()) {
			return "Header = " + null;
		}
		return "Header = " + xValue;
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	Department createDeptAsJson(@RequestBody Department dept) {
		logger.info("POST and JSON combo");
		return deptService.createDepartment(dept);
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/xml", consumes = "application/xml")
	Department createDeptAsXML(@RequestBody Department dept) {
		logger.info("POST and XML combo");
		return deptService.createDepartment(dept);
	}
}
