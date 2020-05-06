package com.spring.controller;

import com.spring.model.Student;
import com.spring.repository.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class StudentController {
    @Autowired
    private StudentRepoImpl studentRepo;
@GetMapping("/students")
    public List<Student> selectAll(){
    return studentRepo.selectAll();
}
}
