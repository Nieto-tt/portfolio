package com.nietott.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nietott.portfolio.model.Skills;
import java.util.List;

import com.nietott.portfolio.service.ISkillsService;


@RestController
@RequestMapping("/skill")
public class SkillsController {

    @Autowired
    ISkillsService service;

    @PostMapping("/new")
    public void newSkills(@RequestBody Skills skills){
        service.newSkills(skills);
    }

    @GetMapping("/get")
    public List<Skills> getSkills(){
        return service.getSkills();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkills(@PathVariable Long id){
        service.deleteSkills(id);
    }

}
