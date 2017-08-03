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

import com.example.rest.model.OrgNotFoundException;
import com.example.rest.model.Organization;
import com.example.rest.service.OrgService;

@RestController
@RequestMapping(value = "/org")
public class OrgController {

	private static Logger logger = LoggerFactory.getLogger(OrgController.class);

	@Autowired
	private OrgService orgService;

	@RequestMapping
	String home() {
		logger.info("Works just fine");
		return "Hi! from Org Service! ";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	Organization getOrgAsJson(@PathVariable("id") int id) {
		logger.info("GET and JSON combo");
		Organization org = orgService.getOrganization(id);
		if (org == null) {
			throw new OrgNotFoundException("No such org exists for id " + id);
		}
		return org;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/xml")
	Organization getOrgAsXML(@PathVariable("id") int id) {
		logger.info("GET and XML combo");
		Organization org = orgService.getOrganization(id);
		if (org == null) {
			throw new OrgNotFoundException("No such org exists for id " + id);
		}
		return org;
	}

	@RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/json")
	Organization getOrgAsJsonWithQueryParam(@RequestParam("id") int id) {
		logger.info("GET with Query Param and Json combo");
		Organization org = orgService.getOrganization(id);
		if (org == null) {
			throw new OrgNotFoundException("No such org exists for id " + id);
		}
		return org;
	}

	@RequestMapping(value = "/fetch", method = RequestMethod.GET, produces = "application/xml")
	Organization getOrgAsXMLWithQueryParam(@RequestParam("id") int id) {
		logger.info("GET with Query Param and XML combo");
		Organization org = orgService.getOrganization(id);
		if (org == null) {
			throw new OrgNotFoundException("No such org exists for id " + id);
		}
		return org;
	}

	@RequestMapping("/validheader")
	String validateOrg(@RequestHeader("variableX") String xValue) {
		if (xValue == null || xValue.isEmpty()) {
			return "Header = " + null;
		}
		return "Header = " + xValue;
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	Organization createOrgAsJson(@RequestBody Organization org) {
		logger.info("POST and JSON combo");
		return orgService.createOrganization(org);
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/xml", consumes = "application/xml")
	Organization createOrgAsXML(@RequestBody Organization org) {
		logger.info("POST and XML combo");
		return orgService.createOrganization(org);
	}
}
