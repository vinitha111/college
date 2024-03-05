package com.st.collegeEx.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.collegeEx.entity.Teacher;
import com.st.collegeEx.exception.AlreadyExistException;
import com.st.collegeEx.exception.NoOneExistException;
import com.st.collegeEx.repo.TeacherRepo;
import com.st.collegeEx.service.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
private TeacherRepo repo;
	@Override
	public Teacher addTeacher(Teacher t)throws AlreadyExistException {
		Optional<Teacher> t1 = repo.findById(t.getId());
		if(t1.isEmpty()) {
		Teacher teacher = repo.save(t);
		return teacher;
		}
		else {
		throw new AlreadyExistException("Already existed with this id :"+t.getId());	
		}
	}

	@Override
	public List<Teacher> getList() {
		List<Teacher> list = repo.findAll();
		return list;
	}

	@Override
	public Teacher getbyId(int id)throws NoOneExistException {
	Optional<Teacher> t = repo.findById(id);
	if(t.isEmpty()) {
		throw new NoOneExistException("No one existed with this id :"+id);
	}
		return t.get();
	}

	@Override
	public void deletebyId(int id)throws NoOneExistException {
		Optional<Teacher> t = repo.findById(id);
		if(t.isEmpty()) {
			throw new NoOneExistException("No one existed with this id :"+id);
		}
		else {
		repo.deleteById(id);
		}
		
	}

	@Override
	public Teacher updateTeacher(int id, Teacher t)throws NoOneExistException {
		Optional<Teacher> t1 = repo.findById(id);
			if(t1.isEmpty()) {
			throw new NoOneExistException("No one existed with this id :"+id);
		}
			else {
		Teacher tc=t1.get();
		tc.setId(t.getId());
		tc.setName(t.getName());
		//tc.setCourse(t.getCourse());
		tc.setSalary(t.getSalary());
		tc.setPhoneNumber(t.getPhoneNumber());
		Teacher teacher = repo.save(tc);
		return teacher;
	}
	}
}
