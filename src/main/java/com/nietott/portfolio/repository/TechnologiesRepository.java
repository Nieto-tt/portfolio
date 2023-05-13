package com.nietott.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nietott.portfolio.model.Technologies;

@Repository
public interface TechnologiesRepository extends JpaRepository <Technologies,Long>{
    
}
