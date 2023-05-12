package com.nietott.portfolio.model;

import java.io.Serializable;
import java.sql.Date;

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
    private Date startDate;
    private Date endDate;
    private String jobDescription;
    private String imageUrl;

    public Experience(){}
}
