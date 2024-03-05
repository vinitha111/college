package com.st.collegeEx.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.collegeEx.entity.Student;
import com.st.collegeEx.exception.AlreadyExistException;
import com.st.collegeEx.exception.NoOneExistException;
import com.st.collegeEx.repo.StudentRepo;
import com.st.collegeEx.service.StudentService;
@Service
public class StudentServiceImpl implements  StudentService{
	@Autowired
 StudentRepo repo;
	@Override
	public Student addStudent(Student s)throws AlreadyExistException {
	
	
	Optional<Student> st = repo.findById(s.getId());
	if(st.isEmpty()) {
		Student student = repo.save(s);
		return student;
	}
	else {
		throw new AlreadyExistException("Already existed with this id :"+s.getId());
	}
	}

	@Override
	public List<Student> getList() {
		List<Student> list = repo.findAll();
		return list;
	}

	@Override
	public Student getbyId(int id)throws NoOneExistException {
		Optional<Student> s = repo.findById(id);
		if(s.isEmpty()) {
			throw new NoOneExistException("No One existed with this id :"+id);
		}
		else {
		return s.get();
	}
	}

	@Override
	public void deletebyId(int id)throws NoOneExistException {
		Optional<Student> s = repo.findById(id);
		if(s.isEmpty()) {
			throw new NoOneExistException("No one existed with this id :"+id);
		}
		else {
				
		repo.deleteById(id);
		}
	}

	@Override
	public Student updateStudent(int id, Student s)throws NoOneExistException {
		Optional<Student> st1 = repo.findById(id);
		if(st1.isEmpty()) {
			throw new NoOneExistException("No One Existed with this id :"+id);
		}
		else {
		Student st=st1.get();
		st.setId(s.getId());
		st.setName(s.getName());
		//st.setCourse(s.getCourse());
		st.setAddress(s.getAddress());
		repo.save(st);
		return st;
	}
	}

	@Override
	public List<Student> searchbyCity(String loc)throws NoOneExistException {
		List<Student> list = repo.findAll().stream().filter(s->s.getAddress().equals(loc)).collect(Collectors.toList());
		if(list.isEmpty()) {
			throw new NoOneExistException("No One Exist in this location  :"+loc);
		}
		else {
		return list;
	}
	}

}
