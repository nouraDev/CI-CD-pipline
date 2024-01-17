package com.example.employeesManagement.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
@Data
@Entity

public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String imageUrl;
    private String email;
    private String jobTitle;
    private String phone;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Employee(String name, String imageUrl, String email, String jobTitle, String phone, String employeeCode) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.employeeCode = employeeCode;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
}
