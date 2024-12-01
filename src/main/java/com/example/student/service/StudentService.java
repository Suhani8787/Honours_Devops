package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student register(Student student) {
        if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new RuntimeException("Email already in use");
        }
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    public Student login(String email, String password) {
        Optional<Student> student = studentRepository.findByEmail(email);
        if (student.isPresent() && passwordEncoder.matches(password, student.get().getPassword())) {
            return student.get();
        }
        throw new RuntimeException("Invalid credentials");
    }

    public Student updatestudent(Long id, Student updatedstudent) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
        student.setName(updatedstudent.getName());
        student.setAddress(updatedstudent.getAddress());
        student.setPhoneNumber(updatedstudent.getPhoneNumber());
        return studentRepository.save(student);
    }

    public Student getstudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
    }
}