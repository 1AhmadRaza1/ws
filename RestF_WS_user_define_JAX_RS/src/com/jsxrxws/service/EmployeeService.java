package com.jsxrxws.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jsxrxws.connection.Connection_WS;
import com.jsxrxws.model.Employee;

@Path("/employee")
public class EmployeeService {
	@GET
	@Path("/getById")
	@Produces("application/json")
	public Employee getbyID(@QueryParam("id") int id)
	{
		Response res=null;
		Employee employee=new Employee();
		Connection connection=null;
		Connection_WS connection_WS=new Connection_WS();
		try {
			connection=connection_WS.getConnection();
			if(connection!=null)
			{
				Statement statement=connection.createStatement();
				ResultSet resultSet=statement.executeQuery("SELECT * FROM employee where eid="+id);
				if(resultSet!=null )
				{
					if(resultSet.next()) {
						employee.setEid(resultSet.getInt("eid"));
						employee.setName(resultSet.getString("name"));
						employee.setEmail(resultSet.getString("email"));
						employee.setPassword(resultSet.getString("password"));
						employee.setMobile(resultSet.getString("mobile"));
					}
				}
				else {
					System.out.println("data not found");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return employee;
	}
	
	@POST
	@Path("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmpoyee(Employee employee){
		Response res=null;
		String name=employee.getName();
		String email=employee.getEmail();
		String password=employee.getPassword();
		String mobile=employee.getMobile();
		Connection connection=null;
		Connection_WS connection_WS=new Connection_WS();
		try {
			connection=connection_WS.getConnection();
			if(connection!=null)
			{
				String sql="insert into employee(name,email,password,mobile)values(?,?,?,?)";
				PreparedStatement statement=connection.prepareStatement(sql);
				statement.setString(1, name);
				statement.setString(2, email);
				statement.setString(3, password);
				statement.setString(4, mobile);
				int addRS=statement.executeUpdate();
				if(addRS>0)
				{
					res=Response.status(200).entity("inserted successfully ").build();
				}else {
					res=Response.status(201).entity("failed").build();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			res=Response.status(202).entity("Exception  :"+e).build();
		}
		return res;
	}

	
	@PUT
	@Path("/update/{id}")
	@Consumes("application/json")
	public Response updateEmployee(@PathParam("id") int eid,Employee employee) {
		
		Response res=null;
		//int id=eid;
		String name=employee.getName();
		String email=employee.getEmail();
		String password=employee.getPassword();
		String mobile=employee.getMobile();
		System.out.println(eid);
		Connection connection=null;
		Connection_WS connection_WS=new Connection_WS();
		try {
			
			connection=connection_WS.getConnection();
			if(connection!=null)
			{
				String sql="update employee set name=?,email=?,password=?,mobile=? where eid="+eid;
				PreparedStatement statement=connection.prepareStatement(sql);
				statement.setString(1, name);
				statement.setString(2, email);
				statement.setString(3, password);
				statement.setString(4, mobile);
				int IRS=statement.executeUpdate();
				if(IRS>0)
				{
					res=Response.status(200).entity("update sucessfully ......").build();
				}else {
					res=Response.status(201).entity("failed update").build();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			res=Response.status(202).entity("Exception  : "+e).build();
		}
		return res;
				
	}
	@DELETE
	@Path("/delete")
	public Response deleteById(@QueryParam("id") int id) {
		Response res=null;
		Connection connection=null;
		Connection_WS connection_WS=new Connection_WS();
		try {
			
			connection=connection_WS.getConnection();
			if(connection!=null)
			{
				String sql="delete from employee where eid="+id;
				PreparedStatement  statement=connection.prepareStatement(sql);
				int irs=statement.executeUpdate();
				if(irs>0) {
					res=Response.status(200).entity("deleted sucessfully ").build();
				}
				else {
					res=Response.status(201).entity("record is not exist ").build();
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			res=Response.status(204).entity("Exception  "+e).build();
		}
		return res;
	}
}
