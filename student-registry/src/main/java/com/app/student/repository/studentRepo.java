package com.app.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.student.entity.Student;

@Repository
public interface studentRepo extends JpaRepository<Student, Integer> {

}
