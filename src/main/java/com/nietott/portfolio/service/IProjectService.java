package com.nietott.portfolio.service;


import com.nietott.portfolio.DTO.projectsDTO;


public interface IProjectService {
    public void newProject(projectsDTO edu/*,  List<Technologies> technologies*/);
    
    public boolean editProject(Long id, projectsDTO edu);
    
    public void deleteProject(Long id);

    public int countProjects();
}
