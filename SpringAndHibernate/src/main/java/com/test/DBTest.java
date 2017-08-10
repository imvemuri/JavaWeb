package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DBTest")
public class DBTest extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String user = "spring";
		String password = "spring";
		String URL = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		
		String driver = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(URL,user,password);
			PrintWriter out = resp.getWriter();
			out.println("DB.Fucked");
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
