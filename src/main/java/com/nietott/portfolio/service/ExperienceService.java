package com.nietott.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.DTO.experienceDTO;
import com.nietott.portfolio.model.Experience;
import com.nietott.portfolio.model.Users;
import com.nietott.portfolio.repository.ExperienceRepository;
import com.nietott.portfolio.repository.UserRepository;

@Service
public class ExperienceService implements IExperienceService{

    @Autowired public ExperienceRepository experienceRepository;
    @Autowired public UserRepository userRepository;


    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public boolean editExperience(Long id, experienceDTO experience) {
        if (!experienceRepository.existsById(id)) {
            return false;
        } else {
            Experience experienceEdited = experienceRepository.findById(id).orElse(null);
            experienceEdited.setUsers(userRepository.findById(experience.getUserId()).orElse(null));
            experienceEdited.setCompanyName(experience.getCompanyName());
            experienceEdited.setJobTitle(experience.getJobTitle());
            experienceEdited.setStartDate(experience.getStartDate());
            experienceEdited.setEndDate(experience.getEndDate());
            experienceEdited.setJobDescription(experience.getJobDescription());
            experienceEdited.setImageUrl(experience.getImageUrl());
    
            experienceRepository.save(experienceEdited);
            return true;
        }
    }

    @Override
    public void newExperience(experienceDTO experience) {
        Users users = userRepository.findById(experience.getUserId()).orElse(null);
        Experience newExperience = new Experience(
                users,
                experience.getCompanyName(),
                experience.getJobTitle(),
                experience.getStartDate(),
                experience.getEndDate(),
                experience.getJobDescription(),
                experience.getImageUrl()
        );
        experienceRepository.save(newExperience);
    }    
   
}
