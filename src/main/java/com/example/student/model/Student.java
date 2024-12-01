package com.example.student.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Student {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    @Column(unique = true, nullable = false)
    private String email;

    @Setter
    @Column(nullable = false)
    private String password;

    @Setter
    @Getter
    private String name;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String phoneNumber;

}
