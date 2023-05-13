package com.nietott.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nietott.portfolio.model.Projects;

@Repository
public interface ProjectsRepository extends JpaRepository <Projects, Long> {
    
}
