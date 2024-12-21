package com.entity;

public class Employee {
	private int id;
	private String name;
	private int age;
	private int sal;
	public Employee(int id,String name,int age,int sal) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.sal=sal;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getSal() {
		return sal;
	}
	public void setId(int n) {
		id=n;
	}
	public void setName(String n) {
		name=n;
	}
	public void setAge(int n) {
		age=n;
	}
	public void setSal(int n) {
		sal=n;
	}
}
