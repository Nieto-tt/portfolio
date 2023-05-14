package com.nietott.portfolio.service;

import com.nietott.portfolio.DTO.experienceDTO;

public interface IExperienceService {
    public void newExperience(experienceDTO edu);
    
    public boolean editExperience(Long id, experienceDTO edu);
    
    public void deleteExperience(Long id);
}
