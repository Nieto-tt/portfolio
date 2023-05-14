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
public class Projects implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    
    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String imageUrl;
    private String liveUrl;

    public Projects(){}
}
