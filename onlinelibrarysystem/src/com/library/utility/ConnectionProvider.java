package com.library.utility;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionProvider {
		
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","simran","simmi123");
		return conn;
	}

	
	}

