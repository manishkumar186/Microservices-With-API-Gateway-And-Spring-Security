package com.example.Department.controller;

import com.example.Department.model.Department;
import com.example.Department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/create")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @GetMapping("/allDepartment")
    public List<Department> getAllDepartment(){
        return departmentService.allDepartment();
    }

    @GetMapping("/departmentId/{id}")
    public Optional<Department> getStudentById(@PathVariable("id") int id){
        return departmentService.getDepartmentById(id);
    }
}
