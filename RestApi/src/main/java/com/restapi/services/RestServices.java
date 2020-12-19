package com.restapi.services;

import java.util.List;

import com.restapi.model.EmployeeEntity;

public interface RestServices {

	public void addEmployee(EmployeeEntity employeeEntity);
	public void updateEmployee(EmployeeEntity employeeEntity);
	public void deleteEmployee(int empID);
	public List<EmployeeEntity> getAllEmployee();
	public EmployeeEntity getByID(int empID);
}
