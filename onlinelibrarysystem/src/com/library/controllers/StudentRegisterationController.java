package com.library.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.daos.StudentDao;
import com.library.daosimpl.StudentDaoImpl;
import com.library.models.Student;

@WebServlet("/StudentRegister")
public class StudentRegisterationController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
    	PrintWriter out=response.getWriter();
    	
    	String s1=request.getParameter("email");
    	String s2=request.getParameter("pwd");
    	String s3=request.getParameter("fName");
    	String s4=request.getParameter("lName");
    	String s5=request.getParameter("gender");
    	String s6=request.getParameter("dob");
    	
    	//Converting String into java.util.Date
    	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	Date dob=null;
		try {
			dob = sdf.parse(s6);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	Student stdObj=new Student();
    	stdObj.setEmail(s1);
    	stdObj.setPassword(s2);
    	stdObj.setFirstName(s3);
    	stdObj.setLastName(s4);
    	stdObj.setGender(s5);
    	stdObj.setDateOfBirth(dob);
    	
    	StudentDao dao=new StudentDaoImpl();
    	boolean r=dao.registerStudent(stdObj);
    	if(r){
    		out.println("Student registered succesfully");
    		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
    		rd.forward(request, response);
    	}
    	else {
    		RequestDispatcher rd=request.getRequestDispatcher("StudentRegister.jsp");
    		rd.forward(request, response);
    				
    	}
    	
	}
	}


