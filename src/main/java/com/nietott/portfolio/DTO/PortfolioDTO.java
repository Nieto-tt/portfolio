package com.nietott.portfolio.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PortfolioDTO {
    private userDTO user;    
    private List<educationDTO> education;   
    private List<experienceDTO> experience;   
    private List<skillsDTO> skill;   
    private List<softskillsDTO> soft;
    private List<projectsDTO> project;
    private List<certificationsDTO> certifications;

    public PortfolioDTO(){}
    
}
