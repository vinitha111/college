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

import com.st.collegeEx.entity.Student;
import com.st.collegeEx.exception.AlreadyExistException;
import com.st.collegeEx.exception.NoOneExistException;
import com.st.collegeEx.service.StudentService;


@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService stuser;

//	@PostMapping("/add")
//	public ResponseEntity<Student> savestudent(@RequestBody Student sttd) throws AlreadyExistsException {
//		Student savest=stuser.addStudent(sttd);
//		return new ResponseEntity<>(savest,HttpStatus.CREATED);
//		
//	}
	@PostMapping("/student/save")
	public void saveStudent(@RequestBody Student sttd) throws AlreadyExistException {
		stuser.addStudent(sttd);
	}

	@GetMapping("/student/list")
	public ResponseEntity<List<Student>> getList() {
		return new ResponseEntity<>(stuser.getList(), HttpStatus.OK);
	}

	@GetMapping("/student/list/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable int id) throws NoOneExistException {
		Student st = stuser.getbyId(id);
		
			return new ResponseEntity<>(st,HttpStatus.NOT_FOUND);
		

	}

	@GetMapping("/student/search/{loc}")
	public ResponseEntity<List<Student>> searchbyCity(@PathVariable String loc) throws  NoOneExistException {
		List<Student> st = stuser.searchbyCity(loc);
		if (st.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(st, HttpStatus.OK);
		}
	}

	@PutMapping("student/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student std)
			throws AlreadyExistException, NoOneExistException {
		Student st = stuser.updateStudent(id,std);

					return new ResponseEntity<>(/* stuser.addStudent(st.get()), */st, HttpStatus.OK);

		
	}

	@DeleteMapping("/student/del/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable int id) throws NoOneExistException {
	      	
			stuser.deletebyId(id);
			return new ResponseEntity<>(HttpStatus.OK);

		

	}

}
