package com.st.collegeEx.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.collegeEx.entity.Course;
import com.st.collegeEx.repo.CourseRepo;
import com.st.collegeEx.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService{
  @Autowired
	private CourseRepo repo;
	@Override
	public Course addCourse(Course c) {
          Course course = repo.save(c);
		return course;
	}
	@Override
	public List<Course> getList() {
List<Course> list = repo.findAll();
		return list;
	}
	@Override
	public Course getbyId(int id) {
		Optional<Course> c = repo.findById(id);
		return c.get();
	}
	@Override
	public void deletebyId(int id) {
		repo.deleteById(id);
		
	}
	@Override
	public Course updateCourse(int id,Course crs) {
		Optional<Course> oc = repo.findById(id);
		Course c=oc.get();
		c.setId(crs.getId());
		c.setName(crs.getName());
		c.setFee(crs.getFee());
		c.setDuration(crs.getDuration());
		return c;
	}
}
