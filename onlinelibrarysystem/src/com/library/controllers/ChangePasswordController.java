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

@WebServlet("/changepwd")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Student std=(Student)session.getAttribute("user1");
		
		String s1=request.getParameter("npass");
		String s2=request.getParameter("cpass");
		if(s1.equals(s2)){
			StudentDao obj=new StudentDaoImpl();
			boolean obj2=obj.changePassword(std.getEmail(),s1,s2);
			if(obj2==true){
				
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				request.setAttribute("msg1", "Password Changed Successfully");
				rd.forward(request, response);
			}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("ChangePassword.jsp");
			request.setAttribute("msg", "Problem in Changing Password");
			rd.forward(request, response);
		}
		}
		
		
	}
}
