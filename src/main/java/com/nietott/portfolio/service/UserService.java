package com.nietott.portfolio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nietott.portfolio.model.Users;
import com.nietott.portfolio.repository.UserRepository;

@Service
public class UserService implements IUserService{

    @Autowired
    public UserRepository repository;

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id); 
    }

    @Override
    public Users findUser(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Users> getUsers() {
        return repository.findAll();
    }

    @Override
    public void newUser(Users user) {
        repository.save(user);
    }

    @Override
    public Users findByEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
}
