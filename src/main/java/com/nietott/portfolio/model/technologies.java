package com.nietott.portfolio.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Technologies implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long technologyId;
    private String name;

    public Technologies(){}
}
