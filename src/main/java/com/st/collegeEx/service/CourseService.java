package com.st.collegeEx.service;

import java.util.List;

import com.st.collegeEx.entity.Course;

public interface CourseService {
	public Course addCourse(Course c); 
	public List<Course> getList();
	public Course getbyId(int id);
	public void deletebyId(int id);
	public Course updateCourse(int id,Course crs);
		
}
