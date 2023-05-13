package com.nietott.portfolio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.DTO.PortfolioDTO;
import com.nietott.portfolio.DTO.certificationsDTO;
import com.nietott.portfolio.DTO.educationDTO;
import com.nietott.portfolio.DTO.experienceDTO;
import com.nietott.portfolio.DTO.projectsDTO;
import com.nietott.portfolio.DTO.skillsDTO;
import com.nietott.portfolio.DTO.softskillsDTO;
import com.nietott.portfolio.DTO.userDTO;
import com.nietott.portfolio.model.Certifications;
import com.nietott.portfolio.model.Education;
import com.nietott.portfolio.model.Experience;
import com.nietott.portfolio.model.Skills;
import com.nietott.portfolio.model.SoftSkills;
import com.nietott.portfolio.model.Users;
import com.nietott.portfolio.repository.CertificationsRepository;
import com.nietott.portfolio.repository.EducationRepository;
import com.nietott.portfolio.repository.ExperienceRepository;
import com.nietott.portfolio.repository.ProjectsRepository;
import com.nietott.portfolio.repository.SkillRepository;
import com.nietott.portfolio.repository.SoftSkillsRepository;
import com.nietott.portfolio.repository.UserRepository;

@Service
public class PortfolioService implements IPortfolioService{

    @Autowired public UserRepository userRepository; 
    @Autowired public EducationRepository educationRepository;
    @Autowired public ExperienceRepository experienceRepository;
    @Autowired public SkillRepository skillRepository;
    @Autowired public SoftSkillsRepository softSkillsRepository;
    @Autowired public ProjectsRepository projectsRepository;
    @Autowired public CertificationsRepository certificationsRepository;
    @Override

    public boolean editUser(userDTO user) {
        if (!userRepository.existsById(user.getUserId())){
            return false;
        } else {
            Users persoEditada = new Users(user.getUserId() , user.getName(), user.getEmail(), user.getPassword(),user.getPhone(),user.getGitUsername(),user.getLinkedinUsername(),user.getDni(),user.getSurname(),user.getImageUrl(),user.getBannerUrl());
            userRepository.save(persoEditada);
            return true;
        }
    }
    @Override
    public PortfolioDTO getPortfolio() {
         // recupera los datos desde la persistencia
         userDTO userDTO = this.getUserDTO();
         List<educationDTO> listEduDto = this.listEduDto();
         List<experienceDTO> listExpeDto = this.listExpeDto();
         List<skillsDTO> listSkillDto = this.listSkillsDTO();
         List<softskillsDTO> listSoftDto = this.listSoftDTO();
         List<certificationsDTO> listCertDto = this.listCertificationsDTO();
         
         // asigna los datos recuperados al portfolio
         PortfolioDTO portfolio = new PortfolioDTO();
         //datos de persona
         portfolio.setUser(userDTO);
         //listas de secciones
         portfolio.setEducation(listEduDto);
         portfolio.setExperience(listExpeDto);
         portfolio.setSkill(listSkillDto);
         portfolio.setSoft(listSoftDto);
         portfolio.setCertifications(listCertDto);
 
         // entrega portfolio
         return portfolio;
    }
    @Override
    public Users getUser() {
        long userId = 1;
        Users user = userRepository.findById(userId).orElse(null);
        return user;
    }
    @Override
    public userDTO getUserDTO() {
        Users user = this.getUser();
        userDTO userDto = new userDTO(user.getUserId() , user.getName(), user.getEmail(), user.getPassword(),user.getPhone(),user.getGitUsername(),user.getLinkedinUsername(),user.getDni(),user.getSurname(),user.getImageUrl(),user.getBannerUrl());
        return userDto;
    }
    @Override
    public List<educationDTO> listEduDto() {
        List<Education> listEdu = educationRepository.findAll();
        List<educationDTO> listEduDto = new ArrayList<educationDTO>();
        
        for (Education edu : listEdu) {
            educationDTO eduDto = new educationDTO(edu.getEduId(), edu.getUsers().getUserId(), edu.getInstitutionName(), edu.getDegreeName(), edu.getFieldOfStudy(), edu.getStartDate(), edu.getEndDate(), edu.getImageUrl());
            listEduDto.add(eduDto);
        }

        return listEduDto;
    }
    @Override
    public List<experienceDTO> listExpeDto() {
        List<Experience> listExpe = experienceRepository.findAll();
        List<experienceDTO> listExpeDto = new ArrayList<>();

        for (Experience expe : listExpe) {
            experienceDTO expeDto = new experienceDTO(expe.getExpId(), expe.getUsers().getUserId(), expe.getCompanyName(), expe.getJobTitle(), expe.getStartDate(), expe.getEndDate(), expe.getJobDescription(), expe.getImageUrl());
            listExpeDto.add(expeDto);
        }

        return listExpeDto;
    }

    /*@Override
    public List<projectsDTO> listProjectsDTO() {
        
        return null;
    }*/

    @Override
    public List<certificationsDTO> listCertificationsDTO() {
        List<Certifications> listCertifications = certificationsRepository.findAll();
        List<certificationsDTO> listcertificationsDTO = new ArrayList<>();
        
        for (Certifications skills : listCertifications) {
            certificationsDTO certificationsDTO = new certificationsDTO(skills.getCertId(), skills.getUsers().getUserId(), skills.getCertificationName(), skills.getInstitutionName(), skills.getDateObtained(), skills.getCertificationUrl(), skills.getImageUrl());
            listcertificationsDTO.add(certificationsDTO);
        }

        return listcertificationsDTO;
    }

    @Override
    public List<skillsDTO> listSkillsDTO() {
        List<Skills> listSkills = skillRepository.findAll();
        List<skillsDTO> listSkillsDto = new ArrayList<>();

        for (Skills skills : listSkills) {
            skillsDTO skillsDto = new skillsDTO(skills.getSkillId(), skills.getUsers().getUserId(), skills.getProficiencyLevel(), skills.getSkillName(), skills.getIcon());
            listSkillsDto.add(skillsDto);
        }

        return listSkillsDto;
    }

    @Override
    public List<softskillsDTO> listSoftDTO() {
        List<SoftSkills> listSoft = softSkillsRepository.findAll();
        List<softskillsDTO> listSoftskillsDTO = new ArrayList<>();

        for (SoftSkills soft:listSoft) {
            softskillsDTO softskillsDTO = new softskillsDTO(soft.getSoftId(), soft.getUsers().getUserId(), soft.getSkillName(), soft.getIcon());
            listSoftskillsDTO.add(softskillsDTO);
        }

        return listSoftskillsDTO;
    }
    
}
