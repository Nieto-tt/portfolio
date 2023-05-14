package com.nietott.portfolio.service;

import com.nietott.portfolio.DTO.technologiesDTO;

public interface ITechnologiesService {
    public void newTechnologies(technologiesDTO edu);
    
    public boolean editTechnologies(Long id, technologiesDTO edu);
    
    public void deleteTechnologies(Long id);
}
