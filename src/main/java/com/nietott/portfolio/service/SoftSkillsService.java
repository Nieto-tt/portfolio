package com.nietott.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.DTO.softskillsDTO;
import com.nietott.portfolio.model.SoftSkills;
import com.nietott.portfolio.model.Users;
import com.nietott.portfolio.repository.SoftSkillsRepository;
import com.nietott.portfolio.repository.UserRepository;

@Service
public class SoftSkillsService implements ISoftSkillsService {

    @Autowired public SoftSkillsRepository softRepository;
    @Autowired public UserRepository userRepository;

    @Override
    public void deleteSoftSkill(Long id) {
        softRepository.deleteById(id);
    }

    @Override
    public boolean editSoftSkill(Long id, softskillsDTO softSkill) {
        if (!softRepository.existsById(id)) {
            return false;
        } else {
            SoftSkills softSkillEdited = softRepository.findById(id).orElse(null);
            softSkillEdited.setUsers(userRepository.findById(softSkill.getUserId()).orElse(null));
            softSkillEdited.setSkillName(softSkill.getSkillName());
            softSkillEdited.setIcon(softSkill.getIcon());
            softRepository.save(softSkillEdited);
            return true;
        }
    }

    @Override
    public void newSoftSkill(softskillsDTO softSkill) {
        Users user = userRepository.findById(softSkill.getUserId()).orElse(null);
        SoftSkills newsoftSkill = new SoftSkills(
            softSkill.getSoftId(),
            user, 
            softSkill.getSkillName(), 
            softSkill.getIcon());
        softRepository.save(newsoftSkill);  
    }
    
    
}
