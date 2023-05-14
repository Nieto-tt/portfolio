package com.nietott.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.DTO.technologiesDTO;
import com.nietott.portfolio.model.Technologies;
import com.nietott.portfolio.repository.TechnologiesRepository;

@Service
public class TechnologiesService implements ITechnologiesService{

    @Autowired public TechnologiesRepository technologiesRepository;

    @Override
    public void deleteTechnologies(Long id) {
        technologiesRepository.deleteById(id);
        
    }

    @Override
    public boolean editTechnologies(Long id, technologiesDTO technologies) {
        if (!technologiesRepository.existsById(id)) {
            return false;
        } else {
            Technologies technologiesEdited = technologiesRepository.findById(id).orElse(null);
            technologiesEdited.setName(technologies.getName());
    
            technologiesRepository.save(technologiesEdited);
            return true;
        }
    }

    @Override
    public void newTechnologies(technologiesDTO technologies) {
        Technologies newTechnology = new Technologies(
            technologies.getTechnologyId(),
            technologies.getName());
        technologiesRepository.save(newTechnology);
    }
    
}
