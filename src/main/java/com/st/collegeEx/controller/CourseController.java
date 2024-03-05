package com.st.collegeEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.collegeEx.entity.Course;
import com.st.collegeEx.service.CourseService;

@RestController
@RequestMapping("/api")
/* @ComponentScan(basePackages= {"com.st.collegeEx.controller"}) */
public class CourseController {
@Autowired	
private CourseService cser;
@PostMapping("/course/save")
public ResponseEntity<Course> saveCourse(@RequestBody Course crs){
	Course c=cser.addCourse(crs);
	return new ResponseEntity<>(c, HttpStatus.CREATED);
}
@GetMapping("/course/list")
public ResponseEntity<List<Course>> getCourses(){
	List<Course> list = cser.getList();
	return new ResponseEntity<>(list, HttpStatus.OK);
}
@GetMapping("/course/list/{id}")
public ResponseEntity<Course>  getCourse(int id){
	Course c = cser.getbyId(id);
	return new ResponseEntity<>(c, HttpStatus.OK);
}
@PutMapping("/course/update/{id}")
public ResponseEntity<Course>  updateCourse(int id,Course crs){
	Course c = cser.updateCourse(id,crs);
	return new ResponseEntity<>(c, HttpStatus.OK);
}
@DeleteMapping("/course/delete/{id}")
public ResponseEntity<Course>  deleteCourse(int id,Course crs){
            cser.deletebyId(id);
	return new ResponseEntity<>( HttpStatus.OK);
}
}