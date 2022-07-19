package com.spring.bd.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";

		try{
			System.out.println("Connecting to dataBase: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			if(myConn != null) {
				System.out.println("Connection Sucsesfull!");
				System.out.println("Connection: " + myConn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
