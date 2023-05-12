package com.nietott.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nietott.portfolio.model.SoftSkills;

@Repository
public interface SoftSkillsRepository extends JpaRepository <SoftSkills,Long>{
    
}
