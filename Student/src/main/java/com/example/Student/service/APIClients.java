package com.example.Student.service;

import com.example.Department.model.Department;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:9092", value = "DEPARTMENT-SERVICE")
public interface APIClients {
    @GetMapping("/department/departmentId/{id}")
    public Department getStudentById(@PathVariable("id") int id);


}
