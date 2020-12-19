package com.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restapi.dao.RestDAO;
import com.restapi.model.EmployeeEntity;

@Service
@Transactional
public class RestServicesImpl implements RestServices {

	@Autowired
	private RestDAO restDao;
	
	@Override
	public void addEmployee(EmployeeEntity employeeEntity) {
		/*
		 * System.out.println("services ..............");
		 * System.out.println(employeeEntity.getName());
		 * System.out.println(employeeEntity.getEmail());
		 * System.out.println(employeeEntity.getPassword());
		 * System.out.println(employeeEntity.getMobile());
		 */		
		restDao.addEmployee(employeeEntity);
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
		
		return restDao.getByID(empID);
	}

}
