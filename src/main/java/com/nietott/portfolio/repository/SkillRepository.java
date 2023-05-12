package com.nietott.portfolio.repository;

import com.nietott.portfolio.model.Skills;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SkillRepository extends JpaRepository <Skills, Long>{

}
