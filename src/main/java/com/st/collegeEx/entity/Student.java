package com.st.collegeEx.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	//private Course course;
	private String address;

	public Student(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		//this.course = c;
		this.address = address;
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
	 * public Course getCourse() { return course; } public void setCourse(Course c)
	 * { this.course = c; }
	 */
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ",  address=" + address + "]";
	}
}
