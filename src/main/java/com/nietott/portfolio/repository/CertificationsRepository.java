package com.nietott.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nietott.portfolio.model.Certifications;

@Repository
public interface CertificationsRepository extends JpaRepository <Certifications, Long>{
    
}
