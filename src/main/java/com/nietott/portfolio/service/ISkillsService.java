package com.nietott.portfolio.service;

import java.util.List;
import com.nietott.portfolio.model.Skills;


public interface ISkillsService {
    public List<Skills> getSkills();

    public void deleteSkills(Long id);

    public void newSkills(Skills skills);

    public Skills findSkills(Long id);
}
