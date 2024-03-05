package com.st.collegeEx.service;

import java.util.List;

import com.st.collegeEx.entity.Teacher;
import com.st.collegeEx.exception.AlreadyExistException;
import com.st.collegeEx.exception.NoOneExistException;

public interface TeacherService {
	public Teacher addTeacher(Teacher t) throws AlreadyExistException; 
	public List<Teacher> getList();
	public Teacher getbyId(int id)throws NoOneExistException;
	public void deletebyId(int id)throws NoOneExistException;
	public Teacher updateTeacher(int id,Teacher t)throws NoOneExistException;
}
