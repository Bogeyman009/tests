package com.org;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("name");
		String email=request.getParameter("email");
		String upwd=request.getParameter("password");
		String mobile=request.getParameter("mob");
		RequestDispatcher dis=null;
		Connection con=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/companys","root","123456789");
			PreparedStatement pre=con.prepareStatement("insert into users(fname,email,userid,password) values(?,?,?,?)");
			pre.setString(1, uname);
			pre.setString(2, email);
			pre.setString(3, mobile);
			pre.setString(4, upwd);
			
			int rowCount=pre.executeUpdate();
			dis=request.getRequestDispatcher("registration.jsp");
			if(rowCount>0) {
				request.setAttribute("status", "success");
			}else {
				dis.forward(request, response);
			}
			
		}catch(Exception e) {
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
;
//		PrintWriter pw=response.getWriter();
//		pw.println(uname);
//		pw.println(email);
//		pw.println(upwd);
//		pw.println(mobile);
//		
	}

}
