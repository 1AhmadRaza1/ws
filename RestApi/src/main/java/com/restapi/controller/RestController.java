package com.restapi.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.restapi.model.EmployeeEntity;
import com.restapi.services.RestServices;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	@Autowired
	private RestServices restServices;
	private DataSource dataSource;
		
	@RequestMapping("/check-connection")
	public String getConnection() throws SQLException
	{
		if(dataSource.getConnection()!=null) {
			System.out.println("connection is available");
		 
		}else {
			System.out.println("connection is failed .......");
		}
		String msg="connection sucessfully .......";
		 
		 return msg;
	}
	
	@PostMapping("/create-employee")
	public String addEmployee(@RequestBody EmployeeEntity employeeEntity)
	{
		/*
		 * System.out.println(employeeEntity.getName());
		 * System.out.println(employeeEntity.getEmail());
		 * System.out.println(employeeEntity.getPassword());
		 * System.out.println(employeeEntity.getMobile());
		 */
		
		String msg="Inserted Successfully .........";
		restServices.addEmployee(employeeEntity);
		
		return " Application " +msg;
	}
	
	@GetMapping("/getbyId/{id}")
	public EmployeeEntity getById(EmployeeEntity employeeEntity,@PathVariable("id") int id) {
		EmployeeEntity employee=restServices.getByID(id);
		return employee;
	}
}
