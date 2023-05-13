package com.nietott.portfolio.controller;

import com.nietott.portfolio.DTO.PortfolioDTO;
import com.nietott.portfolio.model.SoftSkills;
import com.nietott.portfolio.model.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nietott.portfolio.service.ICertificationService;
import com.nietott.portfolio.service.IEducationService;
import com.nietott.portfolio.service.IExperienceService;
import com.nietott.portfolio.service.IPortfolioService;
import com.nietott.portfolio.service.IProjectService;
import com.nietott.portfolio.service.ISkillsService;
import com.nietott.portfolio.service.ISoftSkillsService;
import com.nietott.portfolio.service.IUserService;

@RestController
//@CrossOrigin
public class Controller {
    @Autowired private IUserService userService;
    @Autowired private ISkillsService skillService;
    @Autowired private ISoftSkillsService softService;
    @Autowired private IExperienceService expeService;
    @Autowired private IEducationService eduService;
    @Autowired private ICertificationService certService;
    @Autowired private IProjectService projectService;
    @Autowired private IPortfolioService portfolioService;

    @GetMapping ("/portfolio")
    @ResponseBody
    public ResponseEntity<PortfolioDTO> getPortfolio() {
        PortfolioDTO portfolio = portfolioService.getPortfolio();
        return new ResponseEntity<>(portfolio, HttpStatus.OK);
    }

    /* 
    @PostMapping("/newSoft")
    public void newSoftSkills(@RequestBody SoftSkills SoftSkills){
        softService.newSoftSkills(SoftSkills);
    }

    @GetMapping("/get")
    public List<SoftSkills> getSkills(){
        return softService.getSoftSkills();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSkills(@PathVariable Long id){
        softService.deleteSoftSkills(id);
    }
 
    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<String> login(@PathVariable String email, @PathVariable String password) {
        
        // Verificar si el usuario existe en la base de datos
        Users user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("El usuario no existe");
        }
        
        // Verificar si la contraseña es correcta
        if (!user.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }
        
        // Si el usuario y la contraseña son correctos, se puede iniciar sesión
        return ResponseEntity.ok("Inicio de sesión exitoso");
    }
    */

}
