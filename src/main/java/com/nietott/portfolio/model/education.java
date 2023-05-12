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

@Entity
@AllArgsConstructor
@Data

public class Education implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eduId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    private String institutionName;
    private String degreeName;
    private String fieldOfStudy;
    private Date startDate;
    private Date endDate;
    private String imageUrl;

    public Education(){}
}
