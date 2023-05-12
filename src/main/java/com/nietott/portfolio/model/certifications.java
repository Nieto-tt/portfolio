package com.nietott.portfolio.model;

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
public class certifications {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int certId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;
    private String certificationName;
    private String institutionName;
    private Date dateObtained;
    private String certificationUrl;
    private String imageUrl;

    public certifications(){}
}
