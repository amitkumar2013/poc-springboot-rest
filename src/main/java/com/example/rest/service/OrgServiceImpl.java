package com.example.rest.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest.model.OrgAlreadyException;
import com.example.rest.model.Organization;

@Service
public class OrgServiceImpl implements OrgService {

	private List<Organization> orgList;

	public OrgServiceImpl() {
		orgList = new LinkedList<>();
		orgList.add(new Organization(1, "ISRO"));
		orgList.add(new Organization(2, "NASA"));
	}

	@Override
	public Organization getOrganization(int id) {
		return orgList.stream().filter(org1 -> org1.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Organization createOrganization(Organization org) {
		Organization existingOrg = getOrganization(org.getId());
		if (existingOrg != null) {
			throw new OrgAlreadyException("Organization already exists for id " + org.getId());
		}
		orgList.add(org);
		return getOrganization(org.getId());
	}

}
