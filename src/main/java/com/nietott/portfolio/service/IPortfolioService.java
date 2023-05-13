package com.nietott.portfolio.service;

import java.util.List;

import com.nietott.portfolio.DTO.PortfolioDTO;
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
    public boolean editarPersona(userDTO user);
    
    public userDTO getPersoDto();
    
    public List<educationDTO> listarEduDto();
    
    public List<experienceDTO> listarExpeDto();
    
    public List<skillsDTO> listarHabTecnicaDto();
    
    public List<softskillsDTO> listarHabBlandaDto();
    
    public List<projectsDTO> listarProyeDto();
   
    //Lectura porfolio
    public PortfolioDTO getPortfolio();
}
