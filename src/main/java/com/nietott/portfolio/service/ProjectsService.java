package com.nietott.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.DTO.projectsDTO;
import com.nietott.portfolio.model.Projects;
import com.nietott.portfolio.model.Users;
import com.nietott.portfolio.repository.ProjectsRepository;
import com.nietott.portfolio.repository.UserRepository;

@Service
public class ProjectsService implements IProjectService{

    @Autowired public ProjectsRepository projectRepository;
    @Autowired public UserRepository userRepository;

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
        
    }

    @Override
    public boolean editProject(Long id, projectsDTO project) {
        if (!projectRepository.existsById(id)) {
            return false;
        } else {
            Projects projectEdited = projectRepository.findById(id).orElse(null);
            projectEdited.setUsers(userRepository.findById(project.getUserId()).orElse(null));
            projectEdited.setTitle(project.getTitle());
            projectEdited.setDescription(project.getDescription());
            projectEdited.setStartDate(project.getStartDate());
            projectEdited.setEndDate(project.getEndDate());
            projectEdited.setImageUrl(project.getImageUrl());
            projectEdited.setLiveUrl(project.getLiveUrl());
            projectRepository.save(projectEdited);

            return true;
        }
    }

    @Override
    public void newProject(projectsDTO project /*,List<Technologies> technologies*/) {
        Users users = userRepository.findById(project.getUserId()).orElse(null);
        Projects newproject = new Projects(
            project.getProjectId(),
            users,
            project.getTitle(),
            project.getDescription(),
            project.getStartDate(),
            project.getEndDate(),
            project.getImageUrl(),
            project.getLiveUrl()
            /*technologies*/);
        projectRepository.save(newproject);
    }

    @Override
    public int countProjects() {
        return (int) projectRepository.count();
    }
    
}
