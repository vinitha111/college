package com.st.collegeEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.collegeEx.entity.Teacher;
import com.st.collegeEx.exception.AlreadyExistException;
import com.st.collegeEx.exception.NoOneExistException;
import com.st.collegeEx.service.TeacherService;

@RestController
@RequestMapping("/api")
public class TeacherController {
	@Autowired
private TeacherService tser;
	@PostMapping("/teacher/save")
	public ResponseEntity<Teacher> saveCourse(@RequestBody Teacher tc) throws AlreadyExistException{
		Teacher t=tser.addTeacher(tc);
		return new ResponseEntity<>(t, HttpStatus.CREATED);
	}
	@GetMapping("/teacher/list")
	public ResponseEntity<List<Teacher>> getTeachers(){
		List<Teacher> list = tser.getList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@GetMapping("/teacher/list/{id}")
	public ResponseEntity<Teacher>  getTeacher(@PathVariable int id) throws NoOneExistException{
		Teacher t = tser.getbyId(id);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}
	@PutMapping("/teacher/update/{id}")
	public ResponseEntity<Teacher>  updateTeacher(@PathVariable int id,@RequestBody Teacher tc) throws NoOneExistException{
		Teacher t = tser.updateTeacher(id,tc);
		return new ResponseEntity<>(t, HttpStatus.OK);
	}
	@DeleteMapping("/teacher/delete/{id}")
	public ResponseEntity<Teacher>  deleteTeacher(@PathVariable int id) throws NoOneExistException{
	            tser.deletebyId(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
}
