package com.bookstoreshop.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	public static Connection getallConnection() {
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("driverloaded");
			 
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root","root");
			 System.out.println("connection established");
		 return con;
		
		
		}
			catch(Exception e)
			{
			e.printStackTrace();	
			}
		return null;
	}
	
	
}
