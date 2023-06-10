package com.example.Student.controller;

//import com.example.Student.client.DepartmentClient;
import com.example.Department.model.Department;
import com.example.Student.communicationResponse.Communication;
import com.example.Student.model.Student;
import com.example.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/create")
    public Student addStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> allData(){
        return studentService.allStudentDetail();
    }

    @GetMapping("/studentId/{id}")
    public Communication getStudentById(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }


}
