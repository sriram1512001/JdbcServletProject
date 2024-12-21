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

@WebServlet("/del")
public class DeleteEmployeeData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int  id= Integer.parseInt(req.getParameter("id"));
//	    String name = req.getParameter("name");
//	    int age=Integer.parseInt(req.getParameter("age"));
//	    int sal=Integer.parseInt(req.getParameter("sal"));
	    
	    Employee e1=new Employee(id, null, 0, 0);
	    EmployeService emps=new EmployeService();
	    boolean isDeleted= emps.delete(e1);
	    
	    PrintWriter writer=resp.getWriter();
	    resp.setContentType("text/html");
	    if(isDeleted) {
	    	writer.print("<h1>"+"data deleted succesfully"+"</h1>");
	    	RequestDispatcher rdq=	req.getRequestDispatcher("Home.html");
	    	rdq.forward(req, resp);
//	    	writer.print("<h1>"+"data saved succesfully"+"</h1>");
	    }else {
	    	writer.print("<h1>"+"data is not deleted "+"</h1>");
	    	RequestDispatcher redq=	req.getRequestDispatcher("deleteForm.html");
	    	redq.include(req, resp);
//	    	writer.print("<h1>"+"failed to save data"+"</h1>");
	    }
	}

}
