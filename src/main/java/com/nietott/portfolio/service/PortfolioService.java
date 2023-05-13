package com.nietott.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.DTO.PortfolioDTO;
import com.nietott.portfolio.DTO.educationDTO;
import com.nietott.portfolio.DTO.experienceDTO;
import com.nietott.portfolio.DTO.projectsDTO;
import com.nietott.portfolio.DTO.skillsDTO;
import com.nietott.portfolio.DTO.softskillsDTO;
import com.nietott.portfolio.DTO.userDTO;

import com.nietott.portfolio.model.Users;

import com.nietott.portfolio.repository.EducationRepository;
import com.nietott.portfolio.repository.ExperienceRepository;
import com.nietott.portfolio.repository.ProjectsRepository;
import com.nietott.portfolio.repository.SkillRepository;
import com.nietott.portfolio.repository.SoftSkillsRepository;
import com.nietott.portfolio.repository.UserRepository;

@Service
public class PortfolioService implements IPortfolioService{

    @Autowired public UserRepository user; 
    @Autowired public EducationRepository repoEdu;
    @Autowired public ExperienceRepository repoExpe;
    @Autowired public SkillRepository repoTecnica;
    @Autowired public SoftSkillsRepository repoBlanda;
    @Autowired public ProjectsRepository repoProye;

    @Override
    public boolean editarPersona(userDTO user) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public userDTO getPersoDto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PortfolioDTO getPortfolio() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Users getUser() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<educationDTO> listarEduDto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<experienceDTO> listarExpeDto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<softskillsDTO> listarHabBlandaDto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<skillsDTO> listarHabTecnicaDto() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<projectsDTO> listarProyeDto() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
