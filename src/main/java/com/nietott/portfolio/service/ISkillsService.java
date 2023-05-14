package com.nietott.portfolio.service;


import com.nietott.portfolio.DTO.skillsDTO;


public interface ISkillsService {
    public void newSkill(skillsDTO edu);
    
    public boolean editSkill(Long id, skillsDTO edu);
    
    public void deleteSkill(Long id);
}
