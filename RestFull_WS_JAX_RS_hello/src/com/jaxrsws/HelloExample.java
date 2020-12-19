package com.jaxrsws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/helloExample")
public class HelloExample {

	@Path("/sayHello/{age}")
	@GET
	public String sayHello(@QueryParam("name") String name,@PathParam("age") int age) {
		return "hi :  "+name+"   your age is :  "+age;
	}
}
