package com.nietott.portfolio.service;

import java.util.List;
import com.nietott.portfolio.model.Users;

public interface IUserService {
    public List<Users> getUsers();

    public void newUser(Users user);

    public void deleteUser(Long id);

    public Users findUser(Long id);

    public Users findByEmail(String email);
}
