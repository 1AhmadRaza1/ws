package com.restapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restapi.model.EmployeeEntity;

@Repository
public class RestDAOImpl implements RestDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	public Session getSession() {
		return sessionfactory.getCurrentSession();
	}
	
	@Override
	public void addEmployee(EmployeeEntity employeeEntity) {
		/*
		 * System.out.println("daooooooooooo");
		 * System.out.println(employeeEntity.getName());
		 * System.out.println(employeeEntity.getEmail());
		 * System.out.println(employeeEntity.getPassword());
		 */
		//System.out.println(employeeEntity.getMobile());
		getSession().save(employeeEntity);
	}

	@Override
	public void updateEmployee(EmployeeEntity employeeEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(int empID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeEntity getByID(int empID) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity=getSession().get(EmployeeEntity.class, empID);
		return employeeEntity;
	}

}
