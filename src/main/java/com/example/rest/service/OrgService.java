package com.example.rest.service;

import com.example.rest.model.Organization;

public interface OrgService {

	Organization getOrganization(int id);

	Organization createOrganization(Organization org);

}
