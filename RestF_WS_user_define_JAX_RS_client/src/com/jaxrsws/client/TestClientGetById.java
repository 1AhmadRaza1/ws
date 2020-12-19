package com.jaxrsws.client;

import com.jsxrxws.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class TestClientGetById {

	public static void main(String[] args) {
		
	ClientConfig clientConfig=new DefaultClientConfig();
	clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
	Client client=Client.create(clientConfig);
	WebResource resource=client.resource("http://localhost:8080/RestF_WS_user_define_JAX_RS/rest/employee/getById?id=1");
	Employee empl=resource.accept("application/json").get(Employee.class);
	System.out.println(empl.getEid());
	System.out.println(empl.getName());
	System.out.println(empl.getEmail());
	System.out.println(empl.getPassword());
	System.out.println(empl.getMobile());
	}

}
