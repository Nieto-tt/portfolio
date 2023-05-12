package com.nietott.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class technologies {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long technologyId;
    private String name;
}
