package com.nietott.portfolio.model;

import java.io.Serializable;

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
public class Certifications implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    private String certificationName;
    private String institutionName;
    private String dateObtained;
    private String certificationUrl;
    private String imageUrl;

    public Certifications(){}
}
