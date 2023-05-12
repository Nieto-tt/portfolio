package com.nietott.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.model.SoftSkills;
import com.nietott.portfolio.repository.SoftSkillsRepository;

@Service
public class SoftSkillsService implements ISoftSkillsService {

    @Autowired
    public SoftSkillsRepository repository;

    @Override
    public void deleteSoftSkills(Long id) {
        repository.deleteById(id);
    }

    @Override
    public SoftSkills findSoftSkills(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<SoftSkills> getSoftSkills() {
        return repository.findAll();
    }

    @Override
    public void newSoftSkills(SoftSkills softskills) {
        repository.save(softskills);
    }
    
}
