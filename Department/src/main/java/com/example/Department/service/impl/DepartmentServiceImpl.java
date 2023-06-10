package com.example.Department.service.impl;

import com.example.Department.model.Department;
import com.example.Department.repository.DepartmentRepo;
import com.example.Department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;
    @Override
    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> allDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(int id) {
        return departmentRepo.findById(id);
    }
}
