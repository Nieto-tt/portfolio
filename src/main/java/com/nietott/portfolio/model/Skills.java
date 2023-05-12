package com.nietott.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity

public class Skills {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skillId;
    private int userId;
    private String skillName;
    private String proficiencyLevel;
    private String icon;

    public Skills(){}
}