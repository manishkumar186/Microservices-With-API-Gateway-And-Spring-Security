package com.example.Student.service;

import com.example.Department.model.Department;
import com.example.Student.communicationResponse.Communication;
import com.example.Student.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> allStudentDetail();

    Communication getStudentById(int id);
}
