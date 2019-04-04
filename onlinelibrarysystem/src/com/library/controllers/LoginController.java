package com.library.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.daos.LoginDao;
import com.library.daos.StudentDao;
import com.library.daosimpl.LoginDaoImpl;
import com.library.daosimpl.StudentDaoImpl;
import com.library.models.Login;
import com.library.models.Student;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
		
	   	
		PrintWriter out= response.getWriter();
		
		String s1=request.getParameter("email");
		String s2=request.getParameter("pass");
		
		
		
		LoginDao loginDaoObj=new LoginDaoImpl();
		Login obj=loginDaoObj.validate(s1,s2);
		
				
		if(obj==null) {
			RequestDispatcher rd=request.getRequestDispatcher("Admin.jsp");
			request.setAttribute("errorMsg","Email or Password is incorrect");
			rd.forward(request, response);
		}
		else {
			String role=obj.getRole();
			if(role.equals("Admin")) {
				RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
				rd.forward(request, response);
			}
			else if(role.equals("user")) {
				StudentDao userDaoObj=new StudentDaoImpl();
				Student userObj=userDaoObj.getUser(s1);
				
				
				HttpSession session=request.getSession();
				session.setAttribute("user1",userObj);
				
				RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
				rd.forward(request, response);
			}
		}
		
	}


}
