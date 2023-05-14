package com.nietott.portfolio.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "project_technology")
public class projectTechnologies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/* 
    @ManyToMany
    @JoinTable(name = "project_technologies",
            joinColumns = @JoinColumn(name = "technology_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Projects> projects;

    @ManyToMany
    @JoinTable(name = "project_technologies",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private List<Technologies> technologies;
    */
}