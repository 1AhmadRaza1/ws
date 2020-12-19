package com.RestF_WS_JAX_RS.convertor;

import java.io.File;
import java.io.IOException;

import javax.rmi.CORBA.Stub;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.RestF_WS_JAX_RS.model.Address;
import com.RestF_WS_JAX_RS.model.Student;

public class Java_TO_Json {
	
	public static void main(String[] args) throws JsonGenerationException, IOException {
		Student student=new Student();
		student.setSid(101);
		student.setName("ahmad raza");
		student.setAge(22);
		
		Address address=new Address();
		address.setFlatNo(12);
		address.setBuldingName("anjali apartmenr");
		address.setAreaname("vastrapur");
		
		student.setAddress(address);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(new File("Student.json"), student);
		System.out.println("json with Student File is created ...........");
	}

}
