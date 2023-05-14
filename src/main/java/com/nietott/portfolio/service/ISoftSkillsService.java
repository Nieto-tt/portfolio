package com.nietott.portfolio.service;

import com.nietott.portfolio.DTO.softskillsDTO;

public interface ISoftSkillsService {
    public void newSoftSkill(softskillsDTO edu);
    
    public boolean editSoftSkill(Long id, softskillsDTO edu);
    
    public void deleteSoftSkill(Long id);
}
