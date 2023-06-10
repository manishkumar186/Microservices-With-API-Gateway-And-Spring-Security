package com.example.Student.service.Impl;

import com.example.Department.model.Department;
import com.example.Student.communicationResponse.Communication;
import com.example.Student.model.Student;
import com.example.Student.repository.StudentRepo;
import com.example.Student.service.APIClients;
import com.example.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    StudentRepo studentRepo;

    @Autowired
    APIClients apiClients;

    @Override
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> allStudentDetail() {
        return studentRepo.findAll();
    }

    @Override
    public Communication getStudentById(int id) {
        Student student =  studentRepo.findByStudentId(id);

        Department department = apiClients.getStudentById(student.getDepartmentId());
        Communication communication = new Communication();
        communication.setStudent(student);
        communication.setDepartment(department);

        return communication;

    }
}
