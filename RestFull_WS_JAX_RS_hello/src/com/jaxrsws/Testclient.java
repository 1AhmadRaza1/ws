package com.jaxrsws;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class Testclient { // or you can take another project with same jar single ClientTest class

	public static void main(String[] args) {
		Client client=Client.create();
		WebResource resource=client.resource("http://localhost:8080/RestFull_WS_JAX_RS_hello/rest/helloExample/sayHello/14?name=ahmad");
		String fres=resource.get(String.class);
		System.out.println(fres);
	}
}
