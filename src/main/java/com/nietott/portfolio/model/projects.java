package com.nietott.portfolio.model;

import java.util.Date;
import java.util.HashSet;

import org.hibernate.mapping.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class projects {
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

    public projects(){}
}
