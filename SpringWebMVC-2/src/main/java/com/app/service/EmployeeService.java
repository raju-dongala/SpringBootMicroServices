package com.app.service;

import java.util.List;

import com.app.entity.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeEntity saveEmployeeDetails(EmployeeEntity employeeEntity);
	
	public List<EmployeeEntity> getAllEmployees();
	
	public void deleteEmployee(Integer empId);
	
	public EmployeeEntity getEmployeeById(Integer empId);
	
}
