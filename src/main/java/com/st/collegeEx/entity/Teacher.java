package com.st.collegeEx.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Teacher {
	@Id
	@GeneratedValue
      private int id;
	private String name;
	//private Course course;
	private int  salary;
	private long phoneNumber;
	
	public Teacher(int id, String name,  int salary, long phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		//this.course = course;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public Course getCourse() { return course; } public void setCourse(Course
	 * course) { this.course = course; }
	 */
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name +  ", salary=" + salary + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
