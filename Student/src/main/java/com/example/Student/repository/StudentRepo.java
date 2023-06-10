package com.example.Student.repository;

import com.example.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {


    Student findByStudentId(int id);
}
