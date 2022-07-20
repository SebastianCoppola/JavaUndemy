package com.spring.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//set up connection variables:
		String user = "hbstudent";
		String pass = "hbstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		//get conection to database:
		try{
			PrintWriter out = response.getWriter();
			out.println("\nConnecting to database: " + jdbcUrl);
			Class.forName(driver);
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			out.println("\nConnection Successful.");
			myConn.close();	
		}catch(Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
	}

}
