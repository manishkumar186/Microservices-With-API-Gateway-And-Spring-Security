package com.example.Student.communicationResponse;

import com.example.Department.model.Department;
import com.example.Student.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Communication {

    private Student student;
    private Department department;


}
