package com.example.Department.service;

import com.example.Department.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department createDepartment(Department department);

    List<Department> allDepartment();

    Optional<Department> getDepartmentById(int id);
}
