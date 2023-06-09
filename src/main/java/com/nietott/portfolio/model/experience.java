package com.nietott.portfolio.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Experience implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expId;

    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    private String companyName;
    private String jobTitle;
    private String startDate;
    private String endDate;
    private String jobDescription;
    private String imageUrl;
    
    public Experience(){}

    public Experience(Users users, String companyName, String jobTitle, String startDate, String endDate,
            String jobDescription, String imageUrl) {
        this.users = users;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.imageUrl = imageUrl;
    }

    
}
