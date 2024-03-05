package com.st.collegeEx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.collegeEx.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer>{

}
