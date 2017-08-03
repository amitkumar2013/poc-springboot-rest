package com.example.rest.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest.model.Department;
import com.example.rest.model.DeptAlreadyException;

@Service
public class DeptServiceImpl implements DeptService {

	private List<Department> deptList;

	public DeptServiceImpl() {
		deptList = new LinkedList<>();
		deptList.add(new Department(1, "ISRO", 2000));
		deptList.add(new Department(2, "NASA", 5000));
	}

	@Override
	public Department getDepartment(int id) {
		return deptList.stream().filter(dept1 -> dept1.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Department createDepartment(Department dept) {
		Department existingDept = getDepartment(dept.getId());
		if (existingDept != null) {
			throw new DeptAlreadyException("Department already exists for id " + dept.getId());
		}
		deptList.add(dept);
		return getDepartment(dept.getId());
	}

}
