package com.example.student.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
