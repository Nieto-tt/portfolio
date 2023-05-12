package com.nietott.portfolio.controller;

import java.util.List;

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

import com.nietott.portfolio.model.Users;
import com.nietott.portfolio.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;

    @PostMapping("/new")
    public void newUser(@RequestBody Users user){
        service.newUser(user);
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<String> login(@PathVariable String email, @PathVariable String password) {
        
        // Verificar si el usuario existe en la base de datos
        Users user = service.findByEmail(email);
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


    @GetMapping("/get")
    public List<Users> getUsers(){
        return service.getUsers();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}
