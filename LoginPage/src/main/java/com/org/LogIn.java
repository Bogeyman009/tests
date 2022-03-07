package com.org;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.Session;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("email");
		String pass=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/companys","root","123456789");
			PreparedStatement pre=con.prepareStatement("select * from users where email-? and pass=?");
			pre.setString(1, name);
			pre.setString(2,pass);
			ResultSet res=pre.executeQuery();
			if(res.next())
			{
				session.getAttribute("name",res.getString("name"));
				dispatcher=request.getRequestDispatcher("index.jsp");
		}
			else {
				dispatcher.forward(request,response);
			}
	}

}
