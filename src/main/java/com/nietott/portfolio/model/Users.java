package com.nietott.portfolio.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity

public class Users {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    @Email
    private String email;
    private String password;
    private String phone;
    private String gitUsername;
    private String linkedinUsername;
    private String surname;
    private String imageUrl;
    private String bannerUrl;
    private String description;
    private String ocupation;

    public Users(Long userId, String name, @Email String email, String password, String phone, String gitUsername,
            String linkedinUsername, String surname, String imageUrl, String bannerUrl, String description, String ocupation) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.gitUsername = gitUsername;
        this.linkedinUsername = linkedinUsername;
        this.surname = surname;
        this.imageUrl = imageUrl;
        this.bannerUrl = bannerUrl;
        this.description = description;
        this.ocupation = ocupation;
    }

    
    

    @OneToMany(mappedBy = "users"/* ,cascade = CascadeType.ALL, orphanRemoval = true*/)
    private List<Skills> skills;

    @OneToMany(mappedBy = "users"/* ,cascade = CascadeType.ALL, orphanRemoval = true*/)
    private List<SoftSkills> softskills;

    @OneToMany(mappedBy = "users"/* ,cascade = CascadeType.ALL, orphanRemoval = true*/)
    private List<Projects> projects;

    @OneToMany(mappedBy = "users"/* ,cascade = CascadeType.ALL, orphanRemoval = true*/)
    private List<Certifications> certifications;

    @OneToMany(mappedBy = "users"/* ,cascade = CascadeType.ALL, orphanRemoval = true*/)
    private List<Experience> experience;

    @OneToMany(mappedBy = "users"/* ,cascade = CascadeType.ALL, orphanRemoval = true*/)
    private List<Education> education;

    // Constructor
    public Users(){}
    
}
