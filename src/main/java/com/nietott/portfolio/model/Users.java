package com.nietott.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@Entity

public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long userId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String gitUsername;
    private String linkedinUsername;
    private int dni;
    private String surname;
    private String imageUrl;
    private String bannerUrl;
    
    // Constructor
    public Users(){}
}
