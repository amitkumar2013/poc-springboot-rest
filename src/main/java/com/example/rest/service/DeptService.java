package com.example.rest.service;

import com.example.rest.model.Department;

public interface DeptService {

	Department getDepartment(int id);

	Department createDepartment(Department dept);

}
