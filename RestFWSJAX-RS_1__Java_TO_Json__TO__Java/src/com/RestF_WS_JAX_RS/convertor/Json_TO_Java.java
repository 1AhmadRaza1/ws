package com.RestF_WS_JAX_RS.convertor;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.RestF_WS_JAX_RS.model.Address;
import com.RestF_WS_JAX_RS.model.Student;

public class Json_TO_Java {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		Student student=mapper.readValue(new File("Student.json"), Student.class);
		System.out.println(student.getSid());
		System.out.println(student.getName());
		System.out.println(student.getAge());
		
		Address address=student.getAddress();
		
		System.out.println(address.getFlatNo());
		System.out.println(address.getBuldingName());
		System.out.println(address.getAreaname());
		
	}
}
