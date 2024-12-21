package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Employee;
import com.service.EmployeService;

@WebServlet("/eleven")
public class ShowEmployeeData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeService emps=new EmployeService();
		List<Employee> employees=emps.display();
		PrintWriter writer=resp.getWriter();
		
		 writer.println("<html>");
	        writer.println("<head><title>Employee List</title><link rel=\"stylesheet\" href=\"new.css\"></head>");
	        writer.println("<body>");
	        writer.println("<h1>Employee Data</h1>");
	        writer.println("<table border='1'>");
	        writer.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Salary</th></tr>");
	        for (Employee emp : employees) {
	            writer.println("<tr>");
	            writer.println("<td>" + emp.getId() + "</td>");
	            writer.println("<td>" + emp.getName() + "</td>");
	            writer.println("<td>" + emp.getAge() + "</td>");
	            writer.println("<td>" + emp.getSal() + "</td>");
	            
	            //add edit and delete links
	            writer.println("<td>");
	            writer.println("<a href='editForm.html?id=" + emp.getId() + "'>Edit</a> | ");
	            writer.println("<a href='deleteForm.html?id=" + emp.getId() + "'>Delete</a>");
	            writer.println("</td>");
	            writer.println("</tr>");
	        }
	        writer.println("</table>");
	        writer.println("</body>");
	        writer.println("</html>");
	}
}
