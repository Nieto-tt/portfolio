package com.nietott.portfolio.service;

import com.nietott.portfolio.DTO.educationDTO;

public interface IEducationService {
    public void newEducation(educationDTO edu);
    
    public boolean editEducation(Long id, educationDTO edu);
    
    public void deleteEducation(Long id);
}
