package com.nietott.portfolio.service;

import java.util.List;

import com.nietott.portfolio.DTO.PortfolioDTO;
import com.nietott.portfolio.DTO.certificationsDTO;
import com.nietott.portfolio.DTO.educationDTO;
import com.nietott.portfolio.DTO.experienceDTO;
import com.nietott.portfolio.DTO.projectsDTO;
import com.nietott.portfolio.DTO.skillsDTO;
import com.nietott.portfolio.DTO.softskillsDTO;
import com.nietott.portfolio.DTO.userDTO;
import com.nietott.portfolio.model.Users;

public interface IPortfolioService {

    public Users getUser();
    
    //Modificar persona
    public boolean editUser(userDTO user);
    
    public userDTO getUserDTO();
    
    public List<educationDTO> listEduDto();
    
    public List<experienceDTO> listExpeDto();
    
    public List<skillsDTO> listSkillsDTO();
    
    public List<softskillsDTO> listSoftDTO();
    
   // public List<projectsDTO> listProjectsDTO();

    public List<certificationsDTO> listCertificationsDTO();
   
    //Lectura porfolio
    public PortfolioDTO getPortfolio();
}
