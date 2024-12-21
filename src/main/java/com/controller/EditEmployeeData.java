package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Employee;
import com.service.EmployeService;

@WebServlet("/ed")
public class EditEmployeeData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int  id= Integer.parseInt(req.getParameter("id"));
	    String name = req.getParameter("name");
	    int age=Integer.parseInt(req.getParameter("age"));
	    int sal=Integer.parseInt(req.getParameter("sal"));
	    
	    Employee e1=new Employee(id, name, age, sal);
	    EmployeService emps=new EmployeService();
	    boolean isUpdated= emps.update(e1);
	    
	    PrintWriter writer=resp.getWriter();
	    resp.setContentType("text/html");
	    if(isUpdated) {
	    	writer.print("<h1>"+"data Updated succesfully"+"</h1>");
	    	RequestDispatcher rdq=	req.getRequestDispatcher("Home.html");
	    	rdq.forward(req, resp);
//	    	writer.print("<h1>"+"data saved succesfully"+"</h1>");
	    }else {
	    	writer.print("<h1>"+"data is not updated "+"</h1>");
	    	RequestDispatcher redq=	req.getRequestDispatcher("editForm.html");
	    	redq.include(req, resp);
//	    	writer.print("<h1>"+"failed to save data"+"</h1>");
	    }
	}
}
