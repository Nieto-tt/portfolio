package com.nietott.portfolio.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.model.Skills;
import com.nietott.portfolio.repository.SkillRepository;

@Service
public class SkillsService implements ISkillsService {

    @Autowired 
    public SkillRepository repository;

    @Override
    public void deleteSkills(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Skills findSkills(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Skills> getSkills() {
        return repository.findAll();
    }

    @Override
    public void newSkills(Skills skills) {
        repository.save(skills);
    }
    
}
