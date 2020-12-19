package com.jsxrxws.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_WS {

	public Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Connection connection=null;
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "@ahm@ad");
		if(connection!=null)
		{
			System.out.println("connection is ready");
		}
		else {
				System.out.println("conection is failed");
		}
		return connection;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection_WS connection_WS=new Connection_WS();
		connection_WS.getConnection();
	}
}
