package com.nietott.portfolio.service;

import java.util.List;
import com.nietott.portfolio.model.SoftSkills;

public interface ISoftSkillsService {
    public List<SoftSkills> getSoftSkills();
    
    public void newSoftSkills(SoftSkills softskills);

    public void deleteSoftSkills(Long id);

    public SoftSkills findSoftSkills(Long id);
}
