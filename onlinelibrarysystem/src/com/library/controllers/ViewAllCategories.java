package com.library.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.daos.CategoryDao;
import com.library.daosimpl.CategoryDaoImpl;
import com.library.models.Category;


@WebServlet("/viewAllCategories")
public class ViewAllCategories extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	

	PrintWriter out=response.getWriter();
	
	CategoryDao daoObj=new CategoryDaoImpl();
	List<Category> categoriesList=daoObj.getAllCategories();
	
	request.setAttribute("cList",categoriesList);
	RequestDispatcher rd=request.getRequestDispatcher("ViewCategories.jsp");
	rd.forward(request, response);
			
	
}
}

