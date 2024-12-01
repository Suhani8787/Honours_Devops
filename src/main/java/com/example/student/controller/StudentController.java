package com.example.student.controller;

import com.example.student.model.LoginRequest;
import com.example.student.model.Student;
import com.example.student.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("/register")
    public Student register(@RequestBody Student user) {
        return studentService.register(user);
    }

    @PostMapping("/login")
    public Student login(@RequestBody LoginRequest request) {
        return studentService.login(request.getEmail(), request.getPassword());
    }


    @PutMapping("/{id}")
    public Student updateUser(@PathVariable Long id, @RequestBody Student user) {
        return studentService.updatestudent(id, user);
    }

    @GetMapping("/{id}")
    public Student getUser(@PathVariable Long id) {
        return studentService.getstudent(id);
    }
}