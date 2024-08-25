package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.EmployeeEntity;
import com.app.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo repo;

	public EmployeeEntity saveEmployeeDetails(EmployeeEntity employeeEntity) {
		EmployeeEntity save = repo.save(employeeEntity);
		return save;
	}

	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> all = repo.findAll();
		return all;
	}

	public void deleteEmployee(Integer empId) {
		repo.deleteById(empId);
	}

	public EmployeeEntity getEmployeeById(Integer empId) {
		Optional<EmployeeEntity> byId = repo.findById(empId);
		if(byId.isPresent()) {
			return byId.get();
		}	
		return null;
	}

}
