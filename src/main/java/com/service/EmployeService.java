package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Employee;

public class EmployeService  {
	static String url="jdbc:postgresql://localhost:5432/players";
	static String user="postgres";
	static String pwd="tiger";
	
	public static Connection connection;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("loading resistering done");
			connection=DriverManager.getConnection(url,user,pwd);
			System.out.println(connection);
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("failed to establish database connection");
			e.printStackTrace();
		}
	}
	public boolean save(Employee e) {
		boolean isSaved=false;
		String sql = "INSERT INTO Employee(id, name,age,sal) VALUES (?,?,?,?)";
		try {
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setInt(1,e.getId());
        pstm.setString(2,e.getName());
        pstm.setInt(3,e.getAge());
        pstm.setInt(4,e.getSal());
        
        int rowInserted=pstm.executeUpdate();
        if(rowInserted>0) isSaved=true;

		}catch(SQLException e1) {
			System.out.println("error occurred while saving data");
			e1.printStackTrace();
		}
		return isSaved;
	}
	public boolean update(Employee e) {
		boolean isUpdated=false;
		String sql="UPDATE Employee SET name=?,age=?,sal=? WHERE id=?";
		try {
		PreparedStatement pstmt=connection.prepareStatement(sql);
		
	        pstmt.setString(1,e.getName());
	        pstmt.setInt(2,e.getAge());
	        pstmt.setInt(3,e.getSal());
	        pstmt.setInt(4,e.getId());
	        
	        int rowUpdated=pstmt.executeUpdate();
	        if(rowUpdated>0) isUpdated=true;
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return isUpdated;
	}
	public boolean delete(Employee e) {
		boolean isDelete=false;
		String sql="DELETE from Employee where id=?";
		try {
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1,e.getId());
			int rowDeleted=pstmt.executeUpdate();
			if(rowDeleted>0)isDelete=true;
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return isDelete;
	}
	public List<Employee> display() {
		List<Employee> employeeList=new ArrayList<>();
		String sql="Select * from Employee";
		try {
			Statement st= connection.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				int id=rs.getInt("id");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				int sal=rs.getInt("sal");
				
				Employee emp=new Employee(id,name,age,sal);
				employeeList.add(emp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}
}
