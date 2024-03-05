package com.st.collegeEx.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.collegeEx.entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student ,Integer> {

}
