package com.st.collegeEx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.collegeEx.entity.Teacher;
@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer> {

}
