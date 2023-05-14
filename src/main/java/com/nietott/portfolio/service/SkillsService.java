package com.nietott.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.DTO.skillsDTO;
import com.nietott.portfolio.model.Skills;
import com.nietott.portfolio.model.Users;
import com.nietott.portfolio.repository.SkillRepository;
import com.nietott.portfolio.repository.UserRepository;

@Service
public class SkillsService implements ISkillsService {
    
    @Autowired public SkillRepository skillRepository;
    @Autowired public UserRepository userRepository;

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public boolean editSkill(Long id, skillsDTO skill) {
        if (!skillRepository.existsById(id)) {
            return false;
        } else {
            Skills SkillEdited = skillRepository.findById(id).orElse(null);
            SkillEdited.setUsers(userRepository.findById(skill.getUserId()).orElse(null));
            SkillEdited.setSkillName(skill.getSkillName());
            SkillEdited.setSkillName(skill.getProficiencyLevel());
            SkillEdited.setIcon(skill.getIcon());
            skillRepository.save(SkillEdited);
            return true;
        }
    }

    @Override
    public void newSkill(skillsDTO skill) {
        Users user = userRepository.findById(skill.getUserId()).orElse(null);
        Skills newskill = new Skills(
            skill.getSkillId(),
            user, 
            skill.getSkillName(), 
            skill.getProficiencyLevel(), 
            skill.getIcon());
        skillRepository.save(newskill);  
    }
    
}
