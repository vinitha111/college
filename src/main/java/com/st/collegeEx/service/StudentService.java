package com.st.collegeEx.service;

import java.util.List;
import com.st.collegeEx.entity.Student;
import com.st.collegeEx.exception.AlreadyExistException;
import com.st.collegeEx.exception.NoOneExistException;

public interface StudentService {
	public Student addStudent(Student s)throws AlreadyExistException; 
	public List<Student> getList();
	public Student getbyId(int id)throws NoOneExistException;
	public void deletebyId(int id)throws NoOneExistException;
	public Student updateStudent(int id,Student s)throws NoOneExistException;
	public List<Student> searchbyCity(String loc)throws NoOneExistException;

}
