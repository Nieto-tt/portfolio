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

public class Skills implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    private String skillName;
    private String proficiencyLevel;
    private String icon;

    public Skills(){}
}