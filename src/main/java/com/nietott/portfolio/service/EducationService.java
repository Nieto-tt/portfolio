package com.nietott.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.DTO.educationDTO;
import com.nietott.portfolio.model.Education;
import com.nietott.portfolio.model.Users;
import com.nietott.portfolio.repository.EducationRepository;
import com.nietott.portfolio.repository.UserRepository;

@Service
public class EducationService implements IEducationService{

    @Autowired public EducationRepository educationRepository;
    @Autowired public UserRepository userRepository;

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public boolean editEducation(Long id, educationDTO education) {
        if (!educationRepository.existsById(id)) {
            return false;
        } else {
            Education educationEdited = educationRepository.findById(id).orElse(null);
            educationEdited.setUsers(userRepository.findById(education.getUserId()).orElse(null));
            educationEdited.setInstitutionName(education.getInstitutionName());
            educationEdited.setFieldOfStudy(education.getFieldOfStudy());
            educationEdited.setStartDate(education.getStartDate());
            educationEdited.setEndDate(education.getEndDate());
            educationEdited.setImageUrl(education.getImageUrl());
    
            educationRepository.save(educationEdited);
            return true;
        }
    }

    @Override
    public void newEducation(educationDTO education) {
        Users users = userRepository.findById(education.getUserId()).orElse(null);
        Education newEducation = new Education(education.getEduId(), 
        users, 
        education.getInstitutionName(), 
        education.getDegreeName(), 
        education.getFieldOfStudy(), 
        education.getStartDate(), 
        education.getEndDate(), 
        education.getImageUrl());

        educationRepository.save(newEducation);
    }
    
}
