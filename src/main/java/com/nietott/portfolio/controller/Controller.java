package com.nietott.portfolio.controller;

import com.nietott.portfolio.DTO.PortfolioDTO;
import com.nietott.portfolio.DTO.certificationsDTO;
import com.nietott.portfolio.DTO.educationDTO;
import com.nietott.portfolio.DTO.experienceDTO;
import com.nietott.portfolio.DTO.projectsDTO;
import com.nietott.portfolio.DTO.skillsDTO;
import com.nietott.portfolio.DTO.softskillsDTO;
import com.nietott.portfolio.DTO.technologiesDTO;
import com.nietott.portfolio.DTO.userDTO;
import com.nietott.portfolio.model.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;


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
import com.nietott.portfolio.service.ITechnologiesService;
import com.nietott.portfolio.service.IUserService;

@RestController
@CrossOrigin (origins = "https://portfolio-nietotomas.web.app/", maxAge = 3600)
public class Controller {

    @Autowired private ITechnologiesService technoService ;
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

    @PutMapping ("/editUser")
    public ResponseEntity<?> editUser(@RequestBody userDTO user) {
        if (!portfolioService.editUser(user)){
            return new ResponseEntity<String>("El usuario No existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Informacion cambiada Exitosamente", HttpStatus.OK);
    }

    //

    @PostMapping ("/newProject")
    public ResponseEntity<?> newProject(@RequestBody projectsDTO project){
        projectService.newProject(project);
        return new ResponseEntity<String>("Proyecto "+project.getTitle()+" creado exitosamente ", HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/deleteProject/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return new ResponseEntity<String>("Proyecto borrado Exitosamente!!", HttpStatus.CREATED);
    }
    
    @PutMapping ("/editProject/{id}")
    public ResponseEntity<?> editProject(@PathVariable Long id, @RequestBody projectsDTO project){
        if (!projectService.editProject(id, project)){
            return new ResponseEntity<String>("El Proyecto No Existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Informacion de "+project.getTitle()+" Cambiada Exitosamente!!", HttpStatus.OK);
    }

    @GetMapping ("/countProjects")
    public ResponseEntity<?> countProjects(){
        long count = projectService.countProjects();
        return new ResponseEntity<String>("Cant Proyectos:" + count, HttpStatus.OK);
    }

    //

    @PostMapping ("/newSoftSkill")
    public ResponseEntity<?> newSoftSkill(@RequestBody softskillsDTO softSkill){
        softService.newSoftSkill(softSkill);
        return new ResponseEntity<String>("Habilidad  "+softSkill.getSkillName()+" Añadida exitosamente!!", HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/deleteSoftSkill/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteSoftSkill(@PathVariable Long id){
        softService.deleteSoftSkill(id);
        return new ResponseEntity<String>("Habilidad Borrada Exitosamente ", HttpStatus.CREATED);
    }
    
    @PutMapping ("/editSoftSkill/{id}")
    public ResponseEntity<?> editSoftSkill(@PathVariable Long id, @RequestBody softskillsDTO softSkill){
        if (!softService.editSoftSkill(id, softSkill)){
            return new ResponseEntity<String>("La habilidad No existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Informacion de "+ softSkill.getSkillName()+"cambiada Exitosamente", HttpStatus.OK);
    }

    //

    @PostMapping ("/newSkill")
    public ResponseEntity<?> newSkill(@RequestBody skillsDTO Skill){
        skillService.newSkill(Skill);
        return new ResponseEntity<String>("Habilidad  "+Skill.getSkillName()+" Añadida exitosamente!!", HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/deleteSkill/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteSkill(@PathVariable Long id){
        skillService.deleteSkill(id);
        return new ResponseEntity<String>("Habilidad Borrada Exitosamente ", HttpStatus.CREATED);
    }
    
    @PutMapping ("/editSkill/{id}")
    public ResponseEntity<?> editSkill(@PathVariable Long id, @RequestBody skillsDTO Skill){
        if (!skillService.editSkill(id, Skill)){
            return new ResponseEntity<String>("La habilidad No existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Informacion de "+ Skill.getSkillName()+"cambiada Exitosamente", HttpStatus.OK);
    }

    //

    @PostMapping ("/newCertification")
    public ResponseEntity<?> newCertification(@RequestBody certificationsDTO certification){
        certService.newCertification(certification);
        return new ResponseEntity<String>("La certificación: "+ certification.getCertificationName()+" fue Añadida exitosamente!!", HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/deleteCertification/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteCertification(@PathVariable Long id){
        certService.deleteCertification(id);
        return new ResponseEntity<String>("Certificado Borrado Exitosamente ", HttpStatus.CREATED);
    }
    
    @PutMapping ("/editCertification/{id}")
    public ResponseEntity<?> editCertification(@PathVariable Long id, @RequestBody certificationsDTO certification){
        if (!certService.editCertification(id, certification)){
            return new ResponseEntity<String>("El Certficado No existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Informacion de "+ certification.getCertificationName()+" cambiada Exitosamente", HttpStatus.OK);
    }

    //

    @PostMapping ("/newEducation")
    public ResponseEntity<?> newEducation(@RequestBody educationDTO education){
        eduService.newEducation(education);
        return new ResponseEntity<String>(education.getInstitutionName()+" fue Añadida exitosamente!!", HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/deleteEducation/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteEducation(@PathVariable Long id){
        eduService.deleteEducation(id);
        return new ResponseEntity<String>("Educacion Borrado Exitosamente ", HttpStatus.CREATED);
    }
    
    @PutMapping ("/editEducation/{id}")
    public ResponseEntity<?> editEducation(@PathVariable Long id, @RequestBody educationDTO education){
        if (!eduService.editEducation(id, education)){
            return new ResponseEntity<String>("La Educacion No existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Informacion de "+ education.getInstitutionName()+" fue cambiada Exitosamente", HttpStatus.OK);
    }

    //
    @PostMapping ("/newExperience")
    public ResponseEntity<?> newExperience(@RequestBody experienceDTO experience){
        expeService.newExperience(experience);
        return new ResponseEntity<String>(experience.getCompanyName()+" fue Añadida exitosamente!!", HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/deleteExperience/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteExperience(@PathVariable Long id){
        expeService.deleteExperience(id);
        return new ResponseEntity<String>("Experiencia Borrada Exitosamente ", HttpStatus.CREATED);
    }
    
    @PutMapping ("/editExperience/{id}")
    public ResponseEntity<?> editExperience(@PathVariable Long id, @RequestBody experienceDTO experience){
        if (!expeService.editExperience(id, experience)){
            return new ResponseEntity<String>("La Educacion No existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Informacion de "+ experience.getCompanyName()+" fue cambiada Exitosamente", HttpStatus.OK);
    }

    //

    @PostMapping ("/newTechnologies")
    public ResponseEntity<?> newTechnologies(@RequestBody technologiesDTO techno){
        technoService.newTechnologies(techno);
        return new ResponseEntity<String>(techno.getName()+" fue Añadida exitosamente!!", HttpStatus.CREATED);
    }
    
    @DeleteMapping ("/deleteTechnologies/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteTechnologies(@PathVariable Long id){
        technoService.deleteTechnologies(id);
        return new ResponseEntity<String>("Lenguaje Borrada Exitosamente ", HttpStatus.CREATED);
    }
    
    @PutMapping ("/editTechnologies/{id}")
    public ResponseEntity<?> editTechnologies(@PathVariable Long id, @RequestBody technologiesDTO techno){
        if (!technoService.editTechnologies(id, techno)){
            return new ResponseEntity<String>("La Educacion No existe", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>("Informacion de "+ techno.getName()+" fue cambiada Exitosamente", HttpStatus.OK);
    }

    @PostMapping("/newUser")
    public ResponseEntity<?> newUser(@RequestBody Users user){
        userService.newUser(user);
        return new ResponseEntity<String>(user.getName()+" fue Añadida exitosamente!!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String email, @RequestBody String password) {
        
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
    

}
